package PracticeException;

class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}

public class SimpleExample{
    static void checkAge(int age){
        if(age<18){
            throw new MyException("несовершеннолетний");
        }
        System.out.println("возраст подходит");
    }

    public static void main(String[] args){
        try{
            checkAge(15);
        } catch (MyException e){
            System.out.println("поймали исключение "+e.getMessage());
        } catch (Exception e){
            System.out.println("поймали что-то другое");
        } finally {
            System.out.println("проверка завершена");
        }
    }

}