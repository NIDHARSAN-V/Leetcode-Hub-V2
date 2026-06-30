class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int a = 0, b = 0, c = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            while (a > 0 && b > 0 && c > 0) {
                ans += n - right;

                char lc = s.charAt(left);

                if (lc == 'a') a--;
                else if (lc == 'b') b--;
                else c--;

                left++;
            }
        }

        return ans;
    }
}