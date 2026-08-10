package PracticeException;

public class TicketBookException extends RuntimeException{
    public TicketBookException(){
        super();
    }

    public TicketBookException(String message){
        super(message);
    }

    public TicketBookException(String message, Throwable cause){
        super(message, cause);
    }

    public void bookTicket(int availableSeats){
        if(availableSeats<=0) throw new TicketBookException("Билетов нет в наличии");
        else System.out.println("Билетов забронирован");
    }

    public void parseAndDivide(String numberStr, int divisor){
        try{
            int num = Integer.parseInt(numberStr);
            int res = num / divisor;
        } catch (NumberFormatException e){
            System.out.println("ошибка при парсе числа "+e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("ошибка при делении "+e.getMessage());
        } finally {
            System.out.println("операция завершена");
        }
    }
}
