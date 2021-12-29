package singleResponsibiltity.with;

/*

*/
public class Book {

    private String name;
    private String author;
    private String text;

    public String replaceWordInText(String word) {
        return text.replaceAll(word, text);
    }

    public boolean isWordInText(String word) {
        return text.contains(word);
    }

}
