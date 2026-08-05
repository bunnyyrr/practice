public class Leon extends Animal{
    private double weight;

    public Leon(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
    }

    public void sound(){
        System.out.println("PPАPРР");
    }
}
