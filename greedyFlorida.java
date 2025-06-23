package greedy;
/*You are given:
k: number of friends
c[]: array of original flower prices (length n)

The florist increases the price for each additional flower a person buys:
1st flower = 1 × price
2nd flower = 2 × price
3rd flower = 3 × price
and so on...
Each friend starts with zero flowers, and every time they buy another one, their multiplier increases by 1. */
import java.util.Arrays;

public class greedyFlorida {
    public static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);

        int totalCost = 0;
        int n = c.length;

        // Loop from highest to lowest price
        for (int i = n - 1; i >= 0; i--) {
            int multiplier = ((n - 1 - i) / k) + 1;
            totalCost += multiplier * c[i];
        }

        return totalCost;
    }
}