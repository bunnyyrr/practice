package PracticeException;

public class ConfigLoader {
    public int loadPort(){
        try(FakeFileHandle file = new FakeFileHandle()){
            int port = Integer.parseInt(file.readLine());
            return port;
        }catch(NumberFormatException e){
            throw new ConfigLoadException("ошибка извлечения числа", e);
        }
    }
}
