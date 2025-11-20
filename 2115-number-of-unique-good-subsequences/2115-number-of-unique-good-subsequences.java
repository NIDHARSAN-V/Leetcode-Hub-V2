class Solution {
    public int numberOfUniqueGoodSubsequences(String input) {
        int constant = (int) 1e9 + 7;
        int zeroEnd = 0;
        int oneEnd = 0;
        int flagZero = 0;

        for (int idx = 0; idx < input.length(); idx++) {
            if (input.charAt(idx) == '0') {
                zeroEnd = (zeroEnd + oneEnd) % constant;
                flagZero = 1;
            } else {
                oneEnd = (zeroEnd + oneEnd + 1) % constant;
            }
        }

        return (zeroEnd + oneEnd + flagZero) % constant;
    }
}
