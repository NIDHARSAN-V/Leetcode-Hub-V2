import java.util.*;

class Solution {
    private Map<String, Integer> dp = new HashMap<>(); 
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1; 
        if (coins == null || coins.length == 0) return 0; 
        
      
        return helper(amount, coins, 0);
    }

    private int helper(int amt, int[] coins, int index) {
        
        if (amt == 0) {
            return 1;
        }


        if (amt < 0 || index >= coins.length) {
            return 0;
        }

 
        String key = amt + "," + index;


        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int includeCurrent = helper(amt - coins[index], coins, index);

        int excludeCurrent = helper(amt, coins, index + 1);

        dp.put(key, includeCurrent + excludeCurrent);

        return dp.get(key);
    }
}
