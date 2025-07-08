class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); 
        Integer[][] memo = new Integer[events.length][k + 1];
        return helper(events, k, 0, memo);
    }

    
    private int findNextEvent(int[][] events, int currentEnd, int startIdx) {
        int low = startIdx, high = events.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > currentEnd)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public int helper(int[][] events, int k, int i, Integer[][] memo) {
        if (i == events.length || k == 0) return 0;

        if (memo[i][k] != null) return memo[i][k];

        
        int skip = helper(events, k, i + 1, memo);

        int nextIndex = findNextEvent(events, events[i][1], i + 1);
        int take = events[i][2] + helper(events, k - 1, nextIndex, memo);

        return memo[i][k] = Math.max(skip, take);
    }
}
