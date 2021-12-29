package org.grace.practice.html.parsing.basic;

import java.text.BreakIterator;

public class BreakIteratorTest {

    public static void main(String[] args) {
        String text = "Hello world this is aju";

        BreakIterator bi = BreakIterator.getWordInstance();
        bi.setText(text);
        printAt(bi,7,text);


        System.out.println(bi.following(1));

    }

    //Print the element at a specified position
    public static void printAt(BreakIterator bi, int pos, String source) {
      int end = bi.following(pos);
      int start = bi.previous();
      System.out.println(source.substring(start,end));
  }
}
