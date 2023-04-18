package Viev;

import Model.Employee;

import java.util.List;
import java.util.Scanner;

public class View<T> {
    public void showAllEmployees(List<T> dataList){
        for (T element: dataList) System.out.println(element);
        System.out.println();
    }
    public void filterByParameter(Scanner scanner, Integer userChoice, List<Employee> employees){
        System.out.println();
        if(userChoice == 1){
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            for (Employee employee: employees) {
                if(employee.getFirstName().contains(name))
                    System.out.println(employee);
            }
        }
        if(userChoice == 2){
            System.out.print("Введите фамилию: ");
            String secondName = scanner.nextLine();
            for (Employee employee: employees) {
                if(employee.getSecondName().contains(secondName))
                    System.out.println(employee);
            }
        }
        if(userChoice == 3){
            System.out.print("Введите возраст: ");
            Integer age = scanner.nextInt();
            for (Employee employee: employees) {
                if(employee.getAge().equals(age))
                    System.out.println(employee);
            }
        }

    }
}
