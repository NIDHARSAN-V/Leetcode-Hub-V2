class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        return helper(s, 0, dp);
    }

    private int helper(String s, int start,
                       Map<Integer, Integer> dp) {

        if (start == s.length()) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        int res = 0;

        res += helper(s, start + 1, dp);

      
        if (start + 1 < s.length()) {

            int num = Integer.parseInt(
                    s.substring(start, start + 2));

            if (num >= 10 && num <= 26) {
                res += helper(s, start + 2, dp);
            }
        }

        dp.put(start, res);

        return res;
    }
}