class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();
        int[] freq = new int[n];
        freq[0] = 1;
        for(int i = 1 ; i < n ; i++)
        {
             if(nums.get(i-1) < nums.get(i))
             {
                freq[i] =  freq[i-1] + 1;
             }
             else
             {
                freq[i] = 1;
            }
        }


        for(int i = 0 ; i<n ; i++)
        {
            
            if(freq[i]>=k && (i+k) < n && freq[i+k]>=k)
            {
                return true;
            }
        }
        return false;
    }
}