package Animals;

public class Monkey extends Animal {
    private int intelligence;

    public Monkey(String name, int age, int intelligence){
        super(name, age);
        this.intelligence = intelligence;
    }
    public void sound(){
        System.out.println("ИИУУУ");
    }
}
