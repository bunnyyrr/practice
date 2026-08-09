package PracticeException;

public class Main {
    public static void main(String[] args){
        try{
            ConfigLoader configLoader = new ConfigLoader();
            configLoader.loadPort();
        }catch(ConfigLoadException e){
            System.out.println(e.getMessage() + ", " + e.getCause());
        }
        finally {
            System.out.println("Загрузка завершена");
        }
    }
}
