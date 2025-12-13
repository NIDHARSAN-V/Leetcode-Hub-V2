class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        int right = 0;
        
        // Find the maximum pile size
        for (int i = 0; i < n; i++) {
            right = Math.max(right, piles[i]);
        }

        int ans = right; // Initialize the answer to the maximum pile size
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long time = 0; // Use long to store the total time
            
            for (int i = 0; i < n; i++) {
                time += (piles[i] + mid - 1L) / mid; // Use long arithmetic for safety
            }

            if (time > h) {
                left = mid + 1; // Increase the speed
            } else {
                ans = mid;      // Update the answer
                right = mid - 1; // Try smaller speeds
            }
        }
        return ans;
    }
}