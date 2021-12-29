package theory.creational.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        EmployeeDAO e1 = new EmployeeDAO();
        e1.updateEmployeeListFromDB();
        for(String employeeName: e1.getEmployeeList()){
            System.out.println(employeeName);
        }

        EmployeeDAO e2= e1.clone();
        for(String employeeName: e2.getEmployeeList()){
            System.out.println(employeeName);
        }

    }

}
