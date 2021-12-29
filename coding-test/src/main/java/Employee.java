import java.util.*;

public class Employee {
       /* public String name;
        public List<Employee> listJuniors;


        public Employee(String name) {
            this.name = name;
            listJuniors = new ArrayList<>();
        }

        public void addJunior(Employee junior) {
            listJuniors.add(junior);
        }
    }

class Main{





    private static List<Employee> getSeniors(Employee e1, Employee e2, List<Employee> path){
        if(e1.name == e2.name){

            // found match
            path.add(e2);
            return path;
        }

        if(e1.listJuniors == null){
            return null;
        }


        for(Employee junior: e1.listJuniors){
             List<Employee> pathFound = getSeniors(junior,e2,path);
             if(!pathFound.isEmpty()){
                 pathFound.add(junior);
             }
        }
return null;
    }



    private static void printSeniors() {
        // Hierarchy
        Employee john    = new Employee("John");
        Employee jerry   = new Employee("Jerry");
        Employee harry   = new Employee("Harry");
        Employee butch   = new Employee("Butch");
        Employee garry   = new Employee("Garry");
        Employee tim     = new Employee("Tim");
        Employee tom     = new Employee("Tom");
        Employee jack    = new Employee("Jack");
        Employee jill    = new Employee("Jill");
        Employee ruby    = new Employee("Ruby");
        Employee rebecca = new Employee("Rebecca");

        john.addJunior(jerry);
        john.addJunior(harry);

        jerry.addJunior(tom);

        harry.addJunior(tim);
        // garry reports to both tim and harry
        harry.addJunior(garry);
        tim.addJunior(garry);
        tim.addJunior(butch);

        tom.addJunior(jack);
        tom.addJunior(jill);
        // rebecca reports to both jill and jack
        jill.addJunior(rebecca);
        jack.addJunior(rebecca);
        jack.addJunior(ruby);

    *//*
        Employee name Garry:
        John >> Harry >> Tim >> Garry >>
        John >> Jerry >> Tom >> Garry >>
     *//*
        List<List<String>> seniorPathList = getSeniors(john, garry);
        // List<List<String>> seniorPathList = getSeniors(john, ruby);

        System.out.println("Employee name " + garry.name);
        for(List<String> seniorPath : seniorPathList) {
            for(String senior : seniorPath) {
                System.out.print(senior + " >> ");
            }
            System.out.println();
        }

    }

}*/

}
