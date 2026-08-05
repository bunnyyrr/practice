package Animals;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String name;
    private int limit;
    private List<Animal> animalList = new ArrayList<>();

    public Zoo(String name, int limit){
        this.name = name;
        this.limit = limit;
    }

    public void add(Animal animal){
        if(animal== null) throw new IllegalArgumentException("объект не может быть null");
        else if(animalList.size()>=limit) throw new IllegalArgumentException("превышен лимит животных в зоопарке "+ name);
        else animalList.add(animal);
    }

    public void printAnimals(){
        for(Animal animal: animalList){
            animal.info();
        }
    }

    public void printSkills(){
        for(Animal animal: animalList){
            if(animal instanceof Skill skillfulAnimal){
                skillfulAnimal.swim(animal.getName());
            }
        }
    }

}
