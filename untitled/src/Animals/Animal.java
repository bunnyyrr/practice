package Animals;

abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if(name== null || name.isEmpty()) throw new IllegalArgumentException("Имя не может быть null или пустым");
        else this.name = name;
    }
    public void setAge(int age) {
        if(age>0) this.age = age;
        else throw new IllegalArgumentException("Возраст не может быть отрицательным");
    }

    public void info(){
        System.out.println("Имя: " + name + ", возраст: " + age);
    }

    abstract void sound();
}
