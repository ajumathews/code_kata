package theory.creational.builder;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder().setHdd("500GB").setRam("16GB").setOs("windows").build();
        System.out.println(computer);
    }
}
