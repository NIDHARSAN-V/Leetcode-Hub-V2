class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each number
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxLucky = -1;

        // Check for lucky numbers
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (num == freq) {
                maxLucky = Math.max(maxLucky, num);
            }
        }

        return maxLucky;
    }
}
