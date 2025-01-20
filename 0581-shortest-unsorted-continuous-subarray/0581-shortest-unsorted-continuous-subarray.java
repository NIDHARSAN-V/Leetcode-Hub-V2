class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        // startIdx, endIdx, value
        int start = -1, end = -1, val = Integer.MIN_VALUE;
        int pi = -1; // poll Index
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peekLast()] > nums[i]){
                pi = stack.pollLast();
                // set the start to leftMost index which is not in order
                if(start == -1 || pi < start) start = pi;
                // find the maximum value of elements in stack (which are being polled)
                // reasoning : maximum element's index will be the rightmost after sorting 
                // (or) inserting in the right place
                val = Math.max(nums[pi], val);
            }
            // offer the current Index (this index is in correct position)
            stack.offer(i);
            // if maximum value can be inserted after current element(nums[i]) then that position will be current index + 1. 
            if(val > nums[i]) end = i + 1;
            // if it can't be inserted, then the element was already inserted previously. Now we can reset the value, hoping to catch another value if there are unordered elements in the future.
            else val = Integer.MIN_VALUE;
        }
        // finally return the length from the range observed
        return end - start;
    }
}