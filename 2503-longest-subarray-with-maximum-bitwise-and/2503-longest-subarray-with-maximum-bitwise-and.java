class Solution {
    public int longestSubarray(int[] nums) {
        int max =  0;
        for(int i : nums) max = Math.max(max , i);
        

        int curlen = 0;
        int maxlen = 0;


        for(int i : nums)
        {
            if((i & max)==max)
            {
                curlen++;
                maxlen = Math.max(curlen , maxlen);

            }
            else
            {
                curlen = 0;
            }
        }
        return maxlen;
    }
}