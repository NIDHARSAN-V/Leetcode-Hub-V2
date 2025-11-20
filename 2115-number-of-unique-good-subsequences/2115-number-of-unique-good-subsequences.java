class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        long dp0 = 0, dp1 = 0;
        boolean hasZero = false;
        long mod = 1_000_000_007;

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                dp1 = (dp0 + dp1 + 1) % mod;
            } else {
                hasZero = true;
                dp0 += dp1 % mod;
            }
        }

        return (int)((dp0 + dp1 + (hasZero ? 1 : 0)) % mod);
    }
}
