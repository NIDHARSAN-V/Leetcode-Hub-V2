class Solution {
    public int longestBalanced(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] chars = new int[26];

            for (int j = i; j < s.length(); j++) {

                char c = s.charAt(j);
                chars[c - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (chars[k] > 0) {
                        min = Math.min(min, chars[k]);
                        max = Math.max(max, chars[k]);
                    }
                }

                if (min == max) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
