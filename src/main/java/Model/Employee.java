package Model;

import lombok.Data;

@Data
public class Employee {
    private static int id = 0;
    int uniqueId;
    String firstName;
    String secondName;
    Integer age;
    String speciality;
    Double salary;

    public Employee(String firstName, String secondName, Integer age, String speciality, Double salary) {
        this.uniqueId = getEmployeeID();
//        this.uniqueId = id++;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.speciality = speciality;
        this.salary = salary;
    }
    protected int getEmployeeID(){
        return ++id;
    }

    @Override
    public String toString() {
        return "Employee: id - "+ uniqueId + ", " + firstName + ", " + secondName +
                ", " + age + " лет, " + speciality + ", salary - " + salary;
    }
}
