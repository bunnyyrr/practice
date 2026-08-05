package Animals;

public class Bear extends Animal implements Skill {
    private boolean isInHibernation;

    public Bear(String name, int age, boolean isInHibernation){
        super(name, age);
        this.isInHibernation = isInHibernation;
    }

    public void sound(){
        System.out.println("АААААА");
    }

    public void swim(String name){
        System.out.println(name + " плывет");
    }
}
