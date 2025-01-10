class Solution {

    Map<Integer, Integer> dp = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int result = back(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result; 
    }

    private int back(int[] coins, int amt) {
        if (amt == 0) {
            return 0; 
        }
        if (amt < 0) {
            return Integer.MAX_VALUE; 
        }
        if (dp.containsKey(amt)) {
            return dp.get(amt); 
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amt - coins[i] >= 0) {
                int cou = back(coins, amt - coins[i]);
                if (cou !=Integer.MAX_VALUE) { 
                    min = Math.min(min, cou + 1);
                }
            }
        }
        dp.put(amt,min);
        return  min;
    }
}
