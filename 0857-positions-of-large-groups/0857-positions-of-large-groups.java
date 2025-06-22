class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        // int off = 3;

        List<List<Integer>> res = new ArrayList<>();

        int start =0;
        int end = 0;
        int count =1;

        while(end < s.length() && start < s.length())
        {
            if(start == end)
            {
                count=1;
                end++;
                
            }

            if(  end < s.length() && s.charAt(end) == s.charAt(start))
            {
               end++;
               count++; 
            }
            else
            {
                if(count >= 3)
                {
                    res.add(new ArrayList<>(Arrays.asList(start, end-1)));
                }
                start = end;

            }

            
        }
         if (count >= 3) {
            res.add(new ArrayList<>(Arrays.asList(start, end - 1)));
        }

    return res;
    }
}