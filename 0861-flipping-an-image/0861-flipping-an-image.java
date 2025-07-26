class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = image[i].length - 1;
            while (left <= right) {
                if (image[i][left] == image[i][right]) {
                    image[i][left] = 1 - image[i][left];
                    image[i][right] = image[i][left];
                } else {
                }
                left++;
                right--;
            }
        }
        return image;
    }
}