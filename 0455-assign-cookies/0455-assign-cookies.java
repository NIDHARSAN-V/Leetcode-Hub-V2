class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length;
        int l = 0;
        int r = 0;
        int c  =0;
        while(l < n && r<s.length)
        {
            if(g[l]<=s[r])
            {
               c++;
               l++;
               r++;
            }
            else if(g[l] > s[r])
            {
                r++;
            }
        }
        return c;
    }
}