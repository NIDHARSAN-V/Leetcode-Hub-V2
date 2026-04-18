class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mindis = -1;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int dist = i - map.get(nums[i]);
                if (mindis == -1) {
                    mindis = dist;
                } else {
                    mindis = Math.min(mindis, dist);
                }
            }

            int revnum = reverse(nums[i]);
            map.put(revnum, i);
        }

        return mindis;
    }

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}