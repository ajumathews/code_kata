package theory.thisReference;


/*
For Annonymous inner class when we refer this - it holds the object of the annyonymous inner class

For Lambdas there is no object reference and this refers to the parent object reference and in this
example we cant access it because of static context of main
* */
public class ThisReferenceExample {

    public void doProcess(int i, Process process){
        System.out.println("ThisReference of Main class :"+this);
        process.process(i);
    }

    public static void main(String[] args) {

        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("This Reference of Annonymous class "+this);
                System.out.println("Hello from Annonymous class "+i);
            }
        });

        thisReferenceExample.doProcess(10, (i)->{
            //System.out.println(this); - cant be referred
            System.out.println("Hello From Lambda"+i);
        });

    }
}


interface Process{
    void process(int i);
}