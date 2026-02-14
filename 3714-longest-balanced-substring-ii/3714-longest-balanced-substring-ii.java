import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int ans = Math.max(Single('a', s), Math.max(Single('b', s), Single('c', s)));

        ans = Math.max(ans, Double('a', 'b', 'c', s));
        ans = Math.max(ans, Double('a', 'c', 'b', s));
        ans = Math.max(ans, Double('b', 'c', 'a', s));

        ans = Math.max(ans, Triple(s));

        return ans;
    }

    private int Single(char c, String s) {
        int ans = 1;
        int start = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                ans = Math.max(ans, i - start + 1);
                start = i + 1;
            }
        }

        ans = Math.max(ans, s.length() - start);
        return ans;
    }

    private int Double(char x, char y, char sp, String s) {
        int ans = 0;
        int start = 0;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == sp) {

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, start - 1);

                int diff = 0;
                int ans1 = 0;

                for (int j = start; j < i; j++) {
                    if (s.charAt(j) == x) diff++;
                    else if (s.charAt(j) == y) diff--;

                    if (map.containsKey(diff)) {
                        ans1 = Math.max(ans1, j - map.get(diff));
                    } else {
                        map.put(diff, j);
                    }
                }

                ans = Math.max(ans, ans1);
                start = i + 1;
            }
        }

        return ans;
    }

    private int Triple(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        int a = 0, b = 0, c = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;

            String key = (a - b) + "#" + (a - c);

            if (map.containsKey(key)) {
                maxLen = Math.max(maxLen, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
    }
}
