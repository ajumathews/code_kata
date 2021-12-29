package singleResponsibiltity.without;

import singleResponsibiltity.with.BookFileWriter;

/*
This class violates single responsibility principle.
We can move the writeBookToFile to a seperate class
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

    public void writeBookToFile(String text) {
        System.out.println("Write Book to disk");
    }

}
