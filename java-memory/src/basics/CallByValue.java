package basics;

import java.util.ArrayList;
import java.util.List;

/*

In Java all parameters passed in the methods are copy of the values-  call by Value

In First Method call the copy of the value num in the stack is passed to change Method. So whatever modification done is local to that
method and the name remain unchanged after the execution.

In Second Method call the copy of the reference of the String in the String Pool is passed to the change method.
And by assigning the value in the local method we are actually creating a new String in the String pool and that
reference is assigned to the local variable name. So after method invocation those are removed from stack.
The previous String value remains unchanged


In Third Method call the copy of the reference of the list in the Heap is passed to the change method.
In the method using the reference we can modify the values in the heap. So after the execution the values with the list
is modified


In Fourth Method call the copy of the reference of the list in the Heap is passed to the change method.
In the method we have created a new arraylist and thats reference is assigned to te variable list. After the method execution
these are removed from stack. The original list is unmodified since in the method we are passing only copy of reference
and in method its is reassinging the copy of it. There is no impact.
*/

public class CallByValue {

    public static void main(String[] args) {
        int num = 10;
        System.out.println("num Before Passing " + num);
        changeNum(num);
        System.out.println("Name After Passing " + num);

        String name = "aju";
        System.out.println("Name Before Passing " + name);
        changeName(name);
        System.out.println("Name After Passing " + name);

        List<String> list = new ArrayList<>();
        list.add(name);
        System.out.println("Name Before Passing in the list " + list.get(0));
        changeListValue(list);
        System.out.println("Name Before Passing in the list " + list.get(0));


        List<String> list2 = new ArrayList<>();
        list2.add(name);
        System.out.println("Name Before Passing in the list " + list2.get(0));
        changeListValue2(list2);
        System.out.println("Name Before Passing in the list " + list2.get(0));
    }

    static void changeNum(int num) {
        num = 5;
    }

    static void changeName(String name) {
        name = "Mathew";
    }

    static void changeListValue(List<String> list) {
        list.set(0, "Mathew");
    }

    static void changeListValue2(List<String> list){
        List<String> temp = new ArrayList<>();
        temp.add("Mathew");
        list=temp;
    }
}
