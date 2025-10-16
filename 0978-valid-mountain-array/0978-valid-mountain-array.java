class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false; 
        
        boolean peak = false;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) {
                return false; 
            }

            if (!peak && arr[i - 1] > arr[i]) {
                
                if (i == 1) return false; 
                peak = true;
            } else if (peak && arr[i - 1] <= arr[i]) {
                
                return false;
            }
        }

        return peak;
    }
}
