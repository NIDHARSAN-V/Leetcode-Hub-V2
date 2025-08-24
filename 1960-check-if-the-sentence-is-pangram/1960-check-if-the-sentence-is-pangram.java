class Solution {
    public boolean checkIfPangram(String sentence) {
        
        if (sentence.length() < 26) return false;

        boolean[] seen = new boolean[26];
        int uniqueCount = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            int idx = c - 'a';

           
            int otherIndex = sentence.indexOf(c, i + 1);
            if (!seen[idx] || otherIndex != -1) {
                if (!seen[idx]) {
                    seen[idx] = true;
                    uniqueCount++;
                }
            }
        }

        return uniqueCount == 26;
    }
}
