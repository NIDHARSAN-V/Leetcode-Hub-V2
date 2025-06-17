class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        Boolean[][] dp = new Boolean[n][n]; // DP table to store palindrome info
        rec(0, s, ds, ans, dp);
        return ans;
    }

    private void rec(int i, String s, List<String> ds, List<List<String>> ans, Boolean[][] dp) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j, dp)) {
                ds.add(s.substring(i, j + 1));
                rec(j + 1, s, ds, ans, dp);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j, Boolean[][] dp) {
        if (dp[i][j] != null) return dp[i][j];

        int start = i, end = j;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                dp[i][j] = false;
                return false;
            }
            start++;
            end--;
        }
        dp[i][j] = true;
        return true;
    }
}
