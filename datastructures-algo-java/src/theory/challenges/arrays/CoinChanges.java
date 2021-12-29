package theory.challenges.arrays;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

5

1,1,1,1,1
1,1,1,2,
1,1,3
2,3
2,2,1
5

1, 2, 3, 5
*/
public class CoinChanges {


    int findMaxChange(int[] coins, int sum) {
        List<List<Integer>> combos = new ArrayList<>();
        // {1,2,3}
        // 4

        // find the coins thats will add up to the sum by itself
        // 1 , 2
        // check for divisibility



        return combos.size();
    }


    @Test
    public void test1() {
        int[] coins = {1, 2, 3};
        int sum = 4;
        // {1,1,1,1},{1,1,2},{2,2},{1,3}.
        Assert.assertEquals(4, findMaxChange(coins, sum));
    }

    @Test
    public void test2() {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        // {2,2,2,2,2} ,{2,2,3,3}, {2,2,6} , {2,3,5} , {5,5}
        Assert.assertEquals(5, findMaxChange(coins, sum));
    }

}
