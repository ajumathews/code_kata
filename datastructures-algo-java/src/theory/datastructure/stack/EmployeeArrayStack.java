package theory.datastructure.stack;

import theory.datastructure.model.Employee;

public class EmployeeArrayStack {

    private Employee[] stack;
    private int top;

    public EmployeeArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee e) {
        if (top == stack.length) {
            /*Resize*/
            Employee[] newArray = new Employee[stack.length * 2];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top] = e;
        top++;
    }

    public Employee pop() {
        if (top ==0) {
            return null;
        }
        Employee employee = stack[top - 1];
        stack[top - 1] = null;
        top--;

        return employee;
    }

    public Employee peek() {
        if (top == 0) {
            return null;
        }
        Employee employee = stack[top - 1];
        return employee;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i].toString());
        }

    }
}
