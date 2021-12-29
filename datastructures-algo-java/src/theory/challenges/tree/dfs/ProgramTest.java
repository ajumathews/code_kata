package theory.challenges.tree.dfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProgramTest {
    Program.Node test1;

    public ProgramTest() {
        test1 = new Program.Node("A");
        test1.addChild("B").addChild("C");
        test1.children.get(0).addChild("D");
    }

    @Test
    public void TestCase1() {
        String[] expected = {"A", "B", "D", "C"};
        List<String> inputArray = new ArrayList<String>();

        Assert.assertTrue(compare(test1.depthFirstSearch(inputArray), expected));
    }


    public static boolean compare(List<String> arr1, String[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
