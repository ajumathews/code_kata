package theory.creational.builder;

public class Computer {

    private String ram;
    private String hdd;
    private String os;

    public Computer(String ram, String hdd, String os) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", os='" + os + '\'' +
                '}';
    }

    public static class ComputerBuilder {
        private String ram;
        private String hdd;
        private String os;

        public ComputerBuilder() {
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setHdd(String hdd) {
            this.hdd = hdd;
            return this;
        }

        public ComputerBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(ram, hdd, os);
        }

    }
}
