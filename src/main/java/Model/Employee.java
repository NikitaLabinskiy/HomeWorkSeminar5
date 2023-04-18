package Model;

import lombok.Data;

@Data
public class Employee {
    private static Integer id = 0;
    Integer uniqueId;
    String firstName;
    String secondName;
    Integer age;
    String speciality;
    Double salary;

    public Employee(String firstName, String secondName, Integer age, String speciality, Double salary) {
        this.uniqueId = getUniqueID();
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.speciality = speciality;
        this.salary = salary;
    }
    protected int getUniqueID(){
        return this.uniqueId = ++id;
    }
}
