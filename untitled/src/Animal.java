abstract class Animal {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setName(String newName) {
        if(newName== null || newName.isEmpty()) throw new IllegalArgumentException("Имя не может быть null или пустым");
        else name = newName;
    }
    public void setAge(int newAge) {
        if(newAge>0) age = newAge;
        else throw new IllegalArgumentException("Возраст не может быть отрицательным");
    }

    public void info(){
        System.out.println("Имя: " + name + ", возраст: " + age);
    }

    abstract void sound();
}
