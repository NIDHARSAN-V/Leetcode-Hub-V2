import java.util.*;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Create powers array
        List<Integer> powers = new ArrayList<>();
        int exp = 0;
        String bin = Integer.toBinaryString(n);
        
        // Traverse from right to left (LSB to MSB)
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                powers.add((int)Math.pow(2, exp));
            }
            exp++;
        }
        
        // Step 2: Answer each query
        int MOD = 1_000_000_007;
        int[] ans = new int[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            int left = queries[q][0];
            int right = queries[q][1];
            long product = 1; // Use long to avoid overflow before modulo
            
            for (int i = left; i <= right; i++) {
                product = (product * powers.get(i)) % MOD;
            }
            
            ans[q] = (int)product;
        }
        
        return ans;
    }
}
