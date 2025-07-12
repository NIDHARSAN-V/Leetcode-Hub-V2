class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int f = 0, r = arr.length - 1;

        while (f < r) {
            if (!Character.isLetter(arr[f])) {
                f++;
            } else if (!Character.isLetter(arr[r])) {
                r--;
            } else {
                char temp = arr[f];
                arr[f] = arr[r];
                arr[r] = temp;
                f++;
                r--;
            }
        }

        return new String(arr);
    }
}
