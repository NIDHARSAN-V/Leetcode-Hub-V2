import java.util.*;

class Solution {
    private Map<String, Integer> dp = new HashMap<>(); // Memoization map

    public int change(int amount, int[] coins) {
        if (amount == 0) return 1; // Base case: There's one way to make amount 0 (no coins)
        if (coins == null || coins.length == 0) return 0; // If no coins, no ways to make any amount
        
        // Start the helper function with the full amount and coins
        return helper(amount, coins, 0);
    }

    private int helper(int amt, int[] coins, int index) {
        // Base case: If the amount becomes 0, a valid combination is found
        if (amt == 0) {
            return 1;
        }

        // Base case: If the amount is negative or no coins are left to use
        if (amt < 0 || index >= coins.length) {
            return 0;
        }

        // Create a unique key for the current state (amount and coin index)
        String key = amt + "," + index;

        // Check if the result is already calculated and stored in the map
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // Option 1: Include the current coin and reduce the amount
        int includeCurrent = helper(amt - coins[index], coins, index);

        // Option 2: Exclude the current coin and move to the next coin
        int excludeCurrent = helper(amt, coins, index + 1);

        // Store the total ways in the map
        dp.put(key, includeCurrent + excludeCurrent);

        return dp.get(key);
    }
}
