class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;

        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }

        
        int freq = 0;
        for (int num : nums) {
            if (num == res) freq++;
        }

        if (freq > nums.length / 2) {
            return res;
        }

        return -1; 
    }
}
