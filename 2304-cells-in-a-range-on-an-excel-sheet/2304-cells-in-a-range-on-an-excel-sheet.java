class Solution {
    public List<String> cellsInRange(String s) {
        int startRow = s.charAt(1) - '0';
        int endRow = s.charAt(4) - '0';
        char startCol = s.charAt(0);
        char endCol = s.charAt(3);
        
        int total = (endRow - startRow + 1) * (endCol - startCol + 1);
        List<String> res = new ArrayList<>();


        for(int i = 0 ; i < total ; i++)
        {
            char ch = (char)(startCol + (i / (endRow - startRow + 1)));
            int num = startRow + (i % (endRow - startRow + 1));
            res.add(String.valueOf(ch) +num);
        }

        
        return res;
    }
;}