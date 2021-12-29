package theory.challenges.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseEachWord {


    public String reverseEachWord(String input) {

        // Iterate the input  - my name is aju


        // Stop word is space

        Stack<Character> s = new Stack<>();
        List<String> list = new ArrayList<>();
        for (Character c : input.toCharArray()) {
            if (c != ' ') {
                s.push(c);
            } else{
                StringBuilder sb = new StringBuilder();
                while(!s.isEmpty()){
                  sb.append(s.pop());
                }
                list.add(sb.toString());
            }

        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        list.add(sb.toString());



        return String.join(" ", list);

    }

    @Test
    public void test1() {
        String s = "my name is aju";
        Assert.assertEquals("ym eman si uja", reverseEachWord(s));
    }
}
