public class Cricketer {

    private String name;
    private int runs;

    public Cricketer(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "name='" + name + '\'' +
                ", runs=" + runs +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
}
