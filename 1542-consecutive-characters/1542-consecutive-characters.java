class Solution {
    public int maxPower(String s) {
        int i = 0;
        int max = 0;

        while (i < s.length()) {
            int cur = 1;
            
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                cur++;
                i++;
            }

            max = Math.max(cur, max);
            i++;
        }

        return max;
    }
}
