class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int count = 0;

        for(int i : nums)
        {
            set.add(i);
        }


        for(int i : set)
        {
            if(!set.contains(i-1))
            {
                int x = i;
                count = 1;
                while(set.contains(x+1))
                {
                    count++;
                    x++;
                }

                res = Math.max(count , res);
            }

        }
        return res;
    }
}