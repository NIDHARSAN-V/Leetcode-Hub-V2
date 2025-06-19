class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i<nums.length ;i+=2)
        {
            int f = nums[i];
            int s = nums[i+1];

            for(int j = 0 ; j<f ; j++)
            {
                list.add(s);
            }
        }
         
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    
}