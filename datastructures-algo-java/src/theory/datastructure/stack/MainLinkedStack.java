package theory.datastructure.stack;

import theory.datastructure.model.Employee;

public class MainLinkedStack {

    public static void main(String[] args) {
        Employee aju = new Employee("Aju",31);
        Employee babu= new Employee("Babu",31);
        Employee pavan = new Employee("Pavan",31);

        EmployeeLinkedStack linkedStack = new EmployeeLinkedStack();

        System.out.println("Push");
        linkedStack.push(aju);
        linkedStack.push(babu);
        linkedStack.push(pavan);
        linkedStack.printStack();

        System.out.println("Pop");
        linkedStack.pop();
        linkedStack.printStack();

        System.out.println("Peek");
        linkedStack.peek();
        linkedStack.printStack();


    }
}
