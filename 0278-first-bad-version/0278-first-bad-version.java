/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    int res =0;
    public int firstBadVersion(int n) {
        int l = 0;
        // int res = 0;
        helper(l , n);
        return res;

    }


    private void helper(int l , int r)
    {
        if(l > r)
        {
            return;
        }

        int m = l  + (r-l)/2;


        
        if(isBadVersion(m))
        {
            res = m;
            helper(l, m-1);
        }
        else
        {
          helper(m+1,r);
        }
    }

    
}