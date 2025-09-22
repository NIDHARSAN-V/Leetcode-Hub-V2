class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        Arrays.sort(nums);  

        int count = 1;
        int maxfreq = 0;

        
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] == nums[i-1]) {
                count++;
            } else {
                map.put(nums[i-1], count);
                maxfreq = Math.max(maxfreq, count);
                count = 1;
            }
        }

        
        map.put(nums[nums.length-1], count);
        maxfreq = Math.max(maxfreq, count);

       
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxfreq) {
                res += maxfreq;
            }
        }

        return res;
    }
}
