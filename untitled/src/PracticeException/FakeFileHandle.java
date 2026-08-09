package PracticeException;

public class FakeFileHandle implements AutoCloseable{
    public FakeFileHandle(){
        System.out.println("Файл открыт");
    }

    public String readLine(){
        return "PORT=abc";
    }

    @Override
    public void close() {
        System.out.println("Файл закрыт");
    }
}
