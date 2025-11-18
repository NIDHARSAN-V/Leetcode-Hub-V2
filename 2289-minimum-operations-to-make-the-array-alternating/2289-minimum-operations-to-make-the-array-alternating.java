class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> freqEven = new HashMap<>();
        Map<Integer, Integer> freqOdd  = new HashMap<>();

        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                freqEven.put(nums[i], freqEven.getOrDefault(nums[i], 0) + 1);
            else
                freqOdd.put(nums[i], freqOdd.getOrDefault(nums[i], 0) + 1);
        }

       
        int[] evenTop = getTopTwo(freqEven);
        int e1 = evenTop[0], fe1 = evenTop[1]; 
        int e2 = evenTop[2], fe2 = evenTop[3];

       
        int[] oddTop = getTopTwo(freqOdd);
        int o1 = oddTop[0], fo1 = oddTop[1];
        int o2 = oddTop[2], fo2 = oddTop[3];

        int evenCount = (n + 1) / 2;
        int oddCount = n / 2;

        if (e1 != o1) {
            return (evenCount - fe1) + (oddCount - fo1);
        }

        
        int option1 = (evenCount - fe1) + (oddCount - fo2);
        int option2 = (evenCount - fe2) + (oddCount - fo1);

        return Math.min(option1, option2);
    }

    
    private int[] getTopTwo(Map<Integer, Integer> freq) {
        int v1 = 0, f1 = 0;
        int v2 = 0, f2 = 0;

        for (var e : freq.entrySet()) {
            int val = e.getKey();
            int frq = e.getValue();

            if (frq > f1) {
                v2 = v1; f2 = f1;
                v1 = val; f1 = frq;
            } else if (frq > f2) {
                v2 = val; f2 = frq;
            }
        }
        return new int[] {v1, f1, v2, f2};
    }
}
