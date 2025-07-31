class Solution {

    int count = 0;
    public int countArrangement(int N) {
        if (N == 0) return 0;

        int[] nums = new int[N+1];

        for (int i = 0; i <= N; i++) nums[i] = i;

        helper(nums, N);

        return count;
    }


     private void helper(int[] nums, int start) {

        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
           
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            if (nums[start] % start == 0 || start % nums[start] == 0) helper(nums, start-1);

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }





}