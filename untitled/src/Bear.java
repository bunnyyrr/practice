public class Bear extends Animal{
    private boolean isInHibernation;

    public Bear(String name, int age, boolean isInHibernation){
        super(name, age);
        this.isInHibernation = isInHibernation;
    }
    public void sound(){
        System.out.println("АААААА");
    }
}
