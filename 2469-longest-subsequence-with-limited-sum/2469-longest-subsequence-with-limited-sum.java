class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i++)
        {
            nums[i] += nums[i-1];
        }
        int[] res  =  new int[queries.length];
        int i = 0;
        for(int q : queries)
        {
             int left = 0;
             int right = nums.length-1;
             
             
             while(left <= right)
             {

                int mid = left + (right - left)/2;
                if(nums[mid] <= q)
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }

             }

             res[i++] = left;
        }
        return res;
    }
}