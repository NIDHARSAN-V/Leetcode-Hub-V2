class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxfreq = 0;
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            maxfreq = Math.max(maxfreq, freq);
        }

        int res = 0;
        for (int freq : map.values()) {
            if (freq == maxfreq) {
                res += freq;
            }
        }

        return res;
    }
}
