class Solution {
    public long maximumHappinessSum(int[] happi, int k) {
        Arrays.sort(happi);

        long res = 0;
        int red = 0;
        int i = happi.length - 1;

        while (k > 0 && i >= 0) {
            int curr = happi[i] - red;
            if (curr > 0) {
                res += curr;
            }
            red++;
            i--;
            k--;
        }

        return res;
    }
}
