package Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Data
public class EmployeesDatabase implements Database{
    private List<Employee> database;

    public EmployeesDatabase() {
        this.database = new ArrayList<>();
    }

    @Override
    public void add(Employee employee) {
        this.database.add(employee);
    }

    @Override
    public void remove(Integer id) {
        Iterator<Employee> iterator = database.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getUniqueId() == id){
                iterator.remove();
                break;
            }
        }
    }

    public List<Employee> getDatabase() {
        return database;
    }

    @Override
    public void changeData(Integer inputMenu, Integer employeeId, String inputData) {
        String newData = null;
        if(inputMenu == 1){
            for (Employee employee : database) {
                if(employee.getUniqueId() == employeeId)
                    employee.setFirstName(inputData);
            }
        }
        if(inputMenu == 2){
            for (Employee employee : database) {
                if(employee.getUniqueId() == employeeId)
                    employee.setSecondName(inputData);
            }
        }
        if(inputMenu == 3){
            for (Employee employee : database) {
                if(employee.getUniqueId() == employeeId)
                    employee.setAge(Integer.parseInt(inputData));
            }
        }
        if(inputMenu == 4){
            for (Employee employee : database) {
                if(employee.getUniqueId() == employeeId)
                    employee.setSpeciality(inputData);
            }
        }
        if(inputMenu == 5){
            for (Employee employee : database) {
                if(employee.getUniqueId() == employeeId)
                    employee.setSalary(Double.parseDouble(newData));
            }
        }
    }
}
