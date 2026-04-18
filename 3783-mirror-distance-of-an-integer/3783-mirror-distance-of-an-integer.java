class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int num) {
        int rev = 0;
        int temp = Math.abs(num);

        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }

        return (num < 0) ? -rev : rev;
    }
}