class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int e1 = -1;
        int e2 = -2;
        int c1 = 0;
        int c2 = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(c1 == 0 && e2!=nums[i])
            {
                 c1 = 1;
                 e1 = nums[i];
            }
            else if(c2==0 && e1!=nums[i])
            {
                c2 = 1;
                e2 = nums[i];
            }
            else if(e1 == nums[i])
            {
                c1++;
            }
            else if(e2 == nums[i])
            {
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }



        int f1 = 0;
        int f2 = 0;

        for(int i : nums)
        {
            if(i==e1)
            {
                f1++;
            }

            if(i==e2)
            {
                f2++;
            }
        }


        int n = (nums.length / 3)  +1;
        List<Integer> res  = new ArrayList<>();

        if(f1 >= n)
        {
            res.add(e1);
        }

        if(f2 >= n && e1!=e2)
        {
            res.add(e2);
        }

        return res;


    }
}