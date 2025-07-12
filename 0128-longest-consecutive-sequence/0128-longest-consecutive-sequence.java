import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max_value = 0;

        for (int n : set) { // Iterate over the set to avoid duplicates
            if (!set.contains(n - 1)) { // Start from the beginning of a sequence
                int count = 1;
                int current = n;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                max_value = Math.max(max_value, count);
            }
        }
        return max_value;
    }
}
