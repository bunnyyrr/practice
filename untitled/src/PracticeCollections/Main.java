package PracticeCollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Аня", 50000),
                new Employee("Боря", 70000),
                new Employee("Вера", 60000)
        ));


        Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e2.salary, e1.salary);

        employees.sort(bySalary);
        System.out.println(employees);
    }
}
