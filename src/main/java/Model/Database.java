package Model;


import java.util.Scanner;

public interface Database {
    void add(Employee employee);
    void remove(Integer id);
    void changeData(Integer inputMenu, Integer employeeId, String inputData);
}
