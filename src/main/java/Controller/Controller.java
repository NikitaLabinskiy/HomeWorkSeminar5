package Controller;

import Model.Database;
import Model.Employee;
import Model.EmployeesDatabase;
import Viev.View;

import java.util.List;
import java.util.Scanner;

public class Controller {
    public Controller() {
        Employee employee1 = new Employee("Vladimir", "Ivanov", 24, "Lawyer", 85000.0);
        Employee employee2 = new Employee("Dan", "Saltykov", 28, "Manager", 110000.0);
        Employee employee3 = new Employee("Dmitriy", "Dubovskoy", 24, "Logistician", 75000.0);
        Employee employee4 = new Employee("Anna", "Karenina", 21, "Secretary", 55000.0);
        EmployeesDatabase database = new EmployeesDatabase();
        database.add(employee1);
        database.add(employee2);
        database.add(employee3);
        database.add(employee4);
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        int operation = 0;
        while (!(operation == 7)) {
            System.out.println("\nМеню - выберите необходимое действие:");
            System.out.println("\n(1) Показать информацию всех сотрудников компании.");
            System.out.println("(2) Добавить нового сотрудника в базу данных.");
            System.out.println("(3) Удалить сотрудника из базы данных");
            System.out.println("(4) Фильтер сотрудников по параметрам.");
            System.out.println("(5) Изменить параметры сотрудника.");
            System.out.println("(6) Поиск сотрудника.");
            System.out.println("(7) закрыть программу.");
            System.out.print("\nВведите номер желаемой операции: ");
            operation = scanner.nextInt();
            if(operation == 1 || operation == 3){
                System.out.println("Список сотрудников компании:");
                view.showAllEmployees(database.getDatabase());
            }
            if(operation == 2){
                System.out.print("\nВведите имя сотрудника: ");
                String firstName = scanner.next();
                System.out.print("Введите фамилию сотрудника: ");
                String secondName = scanner.next();
                System.out.print("Введите возраст сотрудника: ");
                int age = scanner.nextInt();
                System.out.print("Введите должность сотрудника: ");
                String speciality = scanner.next();
                System.out.print("Введите размер заработной платы сотрудника: ");
                Double salary = scanner.nextDouble();
                database.add(new Employee(firstName, secondName, age, speciality, salary));
                System.out.println("Сотрудник добален!");
            }
            if (operation == 3){
                System.out.print("\nВведите id сотрудника, которого вы хотите удалить: ");
                int id = scanner.nextInt();
                database.remove(id);
            }
            if(operation == 4){
                System.out.println("\n(1) Фильтр по имени.");
                System.out.println("(2) Фильтр по фамилии.");
                System.out.println("(3) Фильтр по возрасту.");
                System.out.println("(4) Фильтр по должности");
                System.out.println("(5) Фильтр по размеру заработной платы.");
                System.out.print("Введите номер параметра для фильтрации: ");
                int button = scanner.nextInt();
                if(button == 3){
                    System.out.println("\nВведите диапозон фильтрации по возрасту");
                    System.out.print("Введите минимальный возраст в диапозоне (от): ");
                    Double minAge = scanner.nextDouble();
                    System.out.print("Введите максимальный возраст в диапозоне (до): ");
                    Double maxAge = scanner.nextDouble();
                    view.filterByData(minAge, maxAge, button, database.getDatabase());
                }
                if (button == 5){
                    System.out.println("\nВведите диапозон фильтрации по зарплате");
                    System.out.print("Введите минимальную зарплату в диапозоне (от): ");
                    Double minAge = scanner.nextDouble();
                    System.out.print("Введите максимальную зарплату в диапозоне (до): ");
                    Double maxAge = scanner.nextDouble();
                    view.filterByData(minAge, maxAge, button, database.getDatabase());
                } else{
                    System.out.print("\nВедите параметер для фильтрации: ");
                    String inputData = scanner.next();
                    view.filterByStrings(inputData, button, database.getDatabase());
                }
            }
            if (operation == 5){
                System.out.print("\nВведите id сотрудника, данные оторого вы хотите изменить: ");
                int id = scanner.nextInt();
                System.out.println("\n(1) Изменить имя.");
                System.out.println("(2) Изменить фамилию.");
                System.out.println("(3) Изменить возраст.");
                System.out.println("(4) Изменить должность");
                System.out.println("(5) Изменить размер заработной платы.");
                System.out.print("Введите номер параметра для фильтрации: ");
                int button = scanner.nextInt();
                System.out.print("Введите новый параметр: ");
                String newData = scanner.next();
                database.changeData(button, id, newData);
            }
            if (operation == 6){
                System.out.println("\n(1) Поиск по имени.");
                System.out.println("(2) Поиск по фамилии.");
                System.out.println("(3) Поиск по возрасту.");
                System.out.println("(4) Поиск по должности");
                System.out.print("Введите номер параметра для поиска: ");
                int button = scanner.nextInt();
                System.out.print("Введите параметр для поиска: ");
                String newData = scanner.next();
                view.findEmployee(newData, button, database.getDatabase());
            }
        }
        scanner.close();
    }

}
