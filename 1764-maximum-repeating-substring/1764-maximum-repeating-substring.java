class Solution {
    public int maxRepeating(String sequence, String word) {
        int count  = 0;
        String res = word;

        while(sequence.contains(res))
        {
            count++;
            res += word;
        }
        return count;
    }
}