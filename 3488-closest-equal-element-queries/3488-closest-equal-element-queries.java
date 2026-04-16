class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        List<Integer> result = new ArrayList<>();

        int j = 0;
        while (j < queries.length) {
            int q = queries[j];
            int val = nums[q];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                result.add(-1);
                j++;
                continue;
            }

            int pos = Collections.binarySearch(list, q);

            int prev = list.get((pos - 1 + list.size()) % list.size());
            int next = list.get((pos + 1) % list.size());

            int d1 = Math.min(Math.abs(q - prev), n - Math.abs(q - prev));
            int d2 = Math.min(Math.abs(q - next), n - Math.abs(q - next));

            result.add(Math.min(d1, d2));

            j++;
        }

        return result;
    }
}