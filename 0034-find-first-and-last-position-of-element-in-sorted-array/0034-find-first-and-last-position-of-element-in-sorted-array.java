class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x = bin(nums , target , true);
        int y = bin(nums , target , false);
        return new int[]{x , y};
    }

    private int bin(int[] nums , int t , boolean first)
    {
        int i = -1;
        int l = 0;
        int r = nums.length-1;

        while(l  <=  r)
        {
            int mid = l + (r-l)/2;


            if(nums[mid] == t)
            {
                i = mid;

                if(first)
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
            else if(nums[mid] > t)
            {
                r = mid -1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return i;
    }
}