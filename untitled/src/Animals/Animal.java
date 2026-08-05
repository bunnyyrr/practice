package Animals;

abstract class Animal {
    private String name;
    private int age;
    private static int count = 0;

    public Animal(String name, int age){
        setName(name);
        setAge(age);
        count++;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public static int getCount() {
        return count;
    }

    public void setName(String name) {
        if(name== null || name.isEmpty()) throw new IllegalArgumentException("Имя не может быть null или пустым");
        else this.name = name;
    }
    public void setAge(int age) {
        if(age>=0) this.age = age;
        else throw new IllegalArgumentException("Возраст не может быть отрицательным");
    }

    public void info(){
        System.out.println("Имя: " + name + ", возраст: " + age);
    }

    abstract void sound();
}
