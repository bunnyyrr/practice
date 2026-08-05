package Animals;

public class Main {
    public static void main(String[] args){
        Zoo zoo = new Zoo("Новосибирский зоопарк", 4);
        Animal monkey = new Monkey("Толик", 24, 20);
        Animal leon = new Leon("Катя", 19, 156);
        Animal bear = new Bear("Миша", 12, true);
        Animal bear1 = new Bear("Артур", 19, true);

        zoo.add(monkey);
        zoo.add(leon);
        zoo.add(bear);
        zoo.add(bear1);

        zoo.printAnimals();
        zoo.printSkills();
    }
}
