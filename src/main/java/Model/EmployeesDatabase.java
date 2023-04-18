package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeesDatabase implements Database{
    private final List<Employee> database;

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
            if(employee.getUniqueID() == id){
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void changeData(Integer inputMenu, Integer employeeId, String newData) {
        if(inputMenu == 1){
            for (Employee employee : database) {
                if(employee.getUniqueID() == employeeId)
                    employee.setFirstName(newData);
            }
        }
        if(inputMenu == 2){
            for (Employee employee : database) {
                if(employee.getUniqueID() == employeeId)
                    employee.setSecondName(newData);
            }
        }
        if(inputMenu == 3){
            for (Employee employee : database) {
                if(employee.getUniqueID() == employeeId)
                    employee.setAge(Integer.parseInt(newData));
            }
        }
        if(inputMenu == 4){
            for (Employee employee : database) {
                if(employee.getUniqueID() == employeeId)
                    employee.setSpeciality(newData);
            }
        }
        if(inputMenu == 5){
            for (Employee employee : database) {
                if(employee.getUniqueID() == employeeId)
                    employee.setSalary(Double.parseDouble(newData));
            }
        }

    }
}
