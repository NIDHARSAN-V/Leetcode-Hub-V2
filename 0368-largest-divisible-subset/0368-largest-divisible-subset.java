
class Solution {
    public ArrayList<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); 
        int n = nums.length;

        int[] dp = new int[n]; 
        int[] prevIndex = new int[n]; 
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.fill(dp, 1); 
        for (int i = 0; i < n; i++) {
            prevIndex[i] = i; 
        }

        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j; 
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        
        int current = maxIndex;
        while (prevIndex[current] != current) {
            result.add(0, nums[current]); 
            current = prevIndex[current];
        }
        result.add(0, nums[current]); 

        return result;
    }
}
