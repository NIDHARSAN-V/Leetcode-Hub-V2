class Solution {
    public int minimumLength(String s) {
        int[] fre = new int[26];

        for(char ch : s.toCharArray())
        {
            fre[ch - 'a']++;
        }
        int c =0;
        for(int i =0 ; i <  26 ; i++)
        {
            if(fre[i]==0)
            {
                continue;
            }
            if(fre[i]%2 == 0)
            {
                c+=2;
            }
            else
            {
                c+=1;
            }

        }
        return c;
    }
}