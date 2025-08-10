class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        return permuteAndCheck(digits, 0);
    }

    private boolean permuteAndCheck(char[] arr, int index) {
        if (index == arr.length) {
            if (arr[0] == '0') return false; 
            int num = Integer.parseInt(new String(arr));
            return isPowerOfTwo(num);
        }
        
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            if (permuteAndCheck(arr, index + 1)) return true;
            swap(arr, i, index); 
        }
        
        return false;
    }

    private boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
