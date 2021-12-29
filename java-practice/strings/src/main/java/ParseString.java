public class ParseString {

    public static void main(String[] args) {
        String s ="dealTotalPaidSortBy(direction=\"ascending\")";
        //s= s.replaceAll("\"","");

     //   s= s.replaceAll("\"","").replace(")","");
        //System.out.println(s);
        String sortBy = s.substring(0,s.indexOf("("));
        System.out.println(sortBy);
     /*   String sortDirection = (s.substring(s.indexOf("=")+1));
        System.out.println(sortDirection);*/

    }
}
