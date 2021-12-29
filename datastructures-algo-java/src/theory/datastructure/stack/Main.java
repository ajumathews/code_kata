package theory.datastructure.stack;

import theory.datastructure.model.Employee;

public class Main {

    public static void main(String[] args) {
        Employee aju = new Employee("Aju",31);
        Employee babu= new Employee("Babu",31);
        Employee pavan = new Employee("Pavan",31);

        EmployeeArrayStack arrayStack = new EmployeeArrayStack(10);

        arrayStack.pop();
        arrayStack.peek();

        System.out.println("Push");
        arrayStack.push(aju);
        arrayStack.push(babu);
        arrayStack.push(pavan);
        arrayStack.printStack();

        System.out.println("Pop");
        arrayStack.pop();
        arrayStack.printStack();

        System.out.println("Peek");
        arrayStack.peek();
        arrayStack.printStack();


    }
}
