class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;

        for (int end = 1; end <= s.length(); end++) {
     
            if (end == s.length() || s.charAt(end) != s.charAt(start)) {
                if (end - start >= 3) {
                    res.add(new ArrayList<>(Arrays.asList(start, end - 1)));
                }
                start = end; 
            }
        }

        return res;
    }
}
