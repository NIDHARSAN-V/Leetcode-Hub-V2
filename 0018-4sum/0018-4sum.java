

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int x = i + 1; x < n - 2; x++) {
               
                if (x > i + 1 && nums[x] == nums[x - 1]) continue;

                int j = x + 1;
                int k = n - 1;

                while (j < k) {
                    long sum = (long) nums[i] + nums[x] + nums[j] + nums[k];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[x], nums[j], nums[k]));

                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;

                        j++;
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return result;
    }
}