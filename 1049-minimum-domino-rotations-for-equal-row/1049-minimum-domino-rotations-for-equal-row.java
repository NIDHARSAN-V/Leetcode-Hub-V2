class Solution {
    public int minDominoRotations(int[] t, int[] b) {
        int ans = check(t[0], t, b);
        if (ans != -1 ) return ans;
        return check(b[0], t, b);
    }

    private int check(int x, int[] t, int[] b) {
        int rt = 0, rb = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] != x && b[i] != x) return -1;
            else if (t[i] != x) rt++;
            else if (b[i] != x) rb++;
        }
        return Math.min(rt, rb);
    }
}
