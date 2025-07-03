class Solution {
    public char kthCharacter(int k) {
         int index = k - 1;
        int increments = 0;

        // Count how many times we "shifted" this character through the generations
        while (index > 0) {
            long p = 1;
            while (p * 2 <= index) {
                p *= 2;
            }
            increments++;
            index -= p;
        }

        // Compute the final character with wrap-around from 'z' to 'a'
        return (char) ('a' + (increments % 26));
    }
}
