class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = i;        
            pair[i][1] = nums[i];  
        }

        
        Arrays.sort(pair, (a, b) -> Integer.compare(b[1], a[1]));

     
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            indices.add(pair[i][0]);
        }

        
        Collections.sort(indices);

       
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[indices.get(i)];
        }

        return res;
    }
}
