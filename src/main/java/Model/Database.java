package Model;


public interface Database {
    void add(Employee employee);
    void remove(Integer id);
    void changeData(Integer inputMenu, Integer employeeId, String newData);
}
