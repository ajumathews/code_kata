package theory.datastructure.stack;

import theory.datastructure.model.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class EmployeeLinkedStack {

    private LinkedList<Employee> linkedStack;

    public EmployeeLinkedStack() {
        this.linkedStack = new LinkedList<>();
    }

    public void push(Employee e){
        linkedStack.push(e);
    }

    public Employee pop(){
        return linkedStack.pop();
    }

    public Employee peek(){
        return linkedStack.peek();
    }

    public void printStack(){
        Iterator itr= linkedStack.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().toString());
        }
    }

}
