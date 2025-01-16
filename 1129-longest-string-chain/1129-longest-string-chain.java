class Solution {
    public int longestStrChain(String[] words) {
        
        int n = words.length;
        int[] t = new int[n];
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Arrays.fill(t , 1);
        int max  = 1;
        for(int i =1 ; i < n; i++)
        {
            for(int j = 0 ; j< i ; j++)
            {
                if(check_Match(words[i] , words[j]) && 1 + t[j] > t[i]  )
                {
                     t[i] = 1 + t[j];
                }
            }
            max = Math.max(max , t[i]);
        }

        return max;
    }

    private boolean check_Match(String s1, String s2) {
  
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == s2.length();
    }
}