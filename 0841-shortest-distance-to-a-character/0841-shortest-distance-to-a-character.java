class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];

       int prev = Integer.MAX_VALUE;
        
         
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i)==c)
            {
                prev = i;
            }

            res[i] = prev;
        }


        for(int i = s.length() -1 ; i >=0 ; i--)
        {
            if(s.charAt(i)==c)
            {
                prev = i;
            }
            res[i] = Math.min(Math.abs(res[i]- i) , Math.abs(prev-i));
        }
        return res;
    }
}