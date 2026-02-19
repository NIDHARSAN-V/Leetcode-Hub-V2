class Solution {
    public int specialTriplets(int[] nums) {
        long ans = 0;
        long mod = 1_000_000_007;

        Map<Integer, Long> l = new HashMap<>();
        Map<Integer, Long> r = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            r.put(nums[i], r.getOrDefault(nums[i], 0L) + 1);
        }

        for (int j = 0; j < nums.length; j++) {
            int curr = nums[j];
            int t = curr * 2;

            r.put(curr, r.get(curr) - 1);

            long lc = l.getOrDefault(t, 0L);
            long rc = r.getOrDefault(t, 0L);

            ans = (ans + (lc * rc) % mod) % mod;

            l.put(curr, l.getOrDefault(curr, 0L) + 1);
        }

        return (int) ans;
    }
}
