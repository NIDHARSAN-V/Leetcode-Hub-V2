class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = spells.length;
        int n = potions.length;
        int[] pair = new int[m];
        for(int i =0 ; i < m ; i++)
        { 

            int left = 0;
            int right = n - 1;
            // int count =0;

            while(left<=right)
            {
               int mid = left + (right - left)/2;
               long val = (long)spells[i] * potions[mid];

               if(val >= success)
               {
                 right = mid-1;
               }
               else
               {
                // System.out.print(left);
                 left = mid + 1;
               }

            }
            pair[i] = n - left;
        }
        return pair;

    }
}