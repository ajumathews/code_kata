import java.util.*;

public class CollectionsPractice {


    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(1); // Autoboxing


         /*Natural Sorting*/
        List<String> batsman = new ArrayList<>();
        batsman.add("sachin");
        batsman.add("ganguly");
        batsman.add("kohli");
        batsman.set(2, "dhoni");

        System.out.println(batsman.toString());
        Collections.sort(batsman); // natural order
        System.out.println(batsman.toString());

        /*Sorting using Comparator*/
        Collections.sort(batsman, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(batsman.toString());

        /*Sorting classes based on attributes*/
        List<Cricketer> cricketers = new ArrayList<>();
        cricketers.add(new Cricketer("sachin", 1000));
        cricketers.add(new Cricketer("kohli", 500));
        cricketers.add(new Cricketer("akram", 2000));
        cricketers.add(new Cricketer("kumble", 50));

        System.out.println(cricketers.toString());

        Collections.sort(cricketers, new Comparator<Cricketer>() {
            @Override
            public int compare(Cricketer o1, Cricketer o2) {
                if (o1.getRuns() > o2.getRuns())
                    return 1;
                return -1;
            }
        });

        System.out.println(cricketers.toString());


        /*Hashset*/
        Set<String> names = new HashSet<>();
        names.add("aju");
        names.add("babu");
        names.add("sarin");
        names.add("anju");
        names.add("aju"); // returns false.
        System.out.println(names.toString());
        //Cant sort

        /*Treeset*/
        //Sorted
        Set<String> namesTreeset = new TreeSet<>();
        namesTreeset.add("aju");
        namesTreeset.add("babu");
        namesTreeset.add("sarin");
        namesTreeset.add("anju");
        namesTreeset.add("aju"); // returns false.
        System.out.println(namesTreeset.toString());


        /*Sorting Treeset based on attributes
        * While creating pass a comparator anonymouse class
        * */
        Set<Cricketer> cricketerTreeSet = new TreeSet<>(new Comparator<Cricketer>() {
            @Override
            public int compare(Cricketer o1, Cricketer o2) {
                if (o1.getRuns() > o2.getRuns())
                    return 1;
                return -1;
            }
        });
        cricketerTreeSet.add(new Cricketer("sachin", 1000));
        cricketerTreeSet.add(new Cricketer("kohli", 500));
        cricketerTreeSet.add(new Cricketer("akram", 200));
        cricketerTreeSet.add(new Cricketer("kumble", 50));
        System.out.println(cricketerTreeSet.toString());


        /*HashMap
        * Keys are not sorted
        * */
        Map<String, Cricketer> cricketerMap = new HashMap<>();
        cricketerMap.put("sachin",new Cricketer("sachin", 1000));
        cricketerMap.put("kohli",new Cricketer("kohli", 500));
        cricketerMap.put("akram",new Cricketer("akram", 200));
        cricketerMap.put("kumble",new Cricketer("kumble", 50));
        System.out.println(cricketerMap.toString());

        /*TreeMap
         * Stores Keys in sorted way
         * */
        Map<String, Cricketer> cricketerTreeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        cricketerTreeMap.put("sachin",new Cricketer("sachin", 1000));
        cricketerTreeMap.put("kohli",new Cricketer("kohli", 500));
        cricketerTreeMap.put("akram",new Cricketer("akram", 200));
        cricketerTreeMap.put("kumble",new Cricketer("kumble", 50));
        System.out.println(cricketerTreeMap.toString());



        /*Priority Queue -- natural ordering*/
        PriorityQueue<Integer> integersQueue = new PriorityQueue<>();
        integersQueue.add(10);
        integersQueue.add(5);
        integersQueue.add(1);
        integersQueue.add(100);
        System.out.println(integersQueue.toString());/*Unordered*/

        System.out.println(integersQueue.peek());//1 -- dont remove elements
        System.out.println(integersQueue.poll());//1 -- removes the highest priority
        System.out.println(integersQueue.toString());


        /*Priority Queue to maintain priority based on an attribute - pass a comparator*/
        PriorityQueue<Cricketer> crickerQueue = new PriorityQueue<>(new Comparator<Cricketer>() {
            @Override
            public int compare(Cricketer o1, Cricketer o2) {
                if (o1.getRuns() > o2.getRuns())
                    return 1;
                return -1;
            }
        });
        crickerQueue.add(new Cricketer("sachin", 1000));
        crickerQueue.add(new Cricketer("kohli", 500));
        crickerQueue.add(new Cricketer("akram", 200));
        crickerQueue.add(new Cricketer("kumble", 50));
        System.out.println(crickerQueue.toString());/*Ordered based on the comparator*/
        System.out.println(crickerQueue.peek());//1 -- dont remove elements

    }
}
