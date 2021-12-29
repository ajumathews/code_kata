import java.util.ArrayList;
import java.util.List;

public class LowerBoundWildCard {

    static void addCat(List<? super Cat> catList){
        catList.add(new BlackCat());
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<BlackCat> blackCats = new ArrayList<>();

        addCat(animals);
        addCat(cats);

       /* addCat(blackCats);
         compilation Error
         * */
    }


}


class Animal{}

class Cat extends  Animal{}

class BlackCat extends Cat{}
