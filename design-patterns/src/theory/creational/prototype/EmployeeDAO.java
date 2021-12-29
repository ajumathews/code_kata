package theory.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements Cloneable {

    private List<String> employeeList;

    public void updateEmployeeListFromDB() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        employeeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            employeeList.add("Employee " + i);
        }
    }

    public List<String> getEmployeeList() {
        return employeeList;
    }

    public EmployeeDAO clone() throws CloneNotSupportedException{
        System.out.println("Cloning EmployeeDAO");
        return (EmployeeDAO) super.clone();
    }
}
