class Solution {
    public String findLongestWord(String s, List<String> dic) {
        
        Collections.sort(dic, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length(); 
            } else {
                return a.compareTo(b); 
            }
        });

   
        for (String word : dic) {
            if (helper(s, word)) {
                return word;
            }
        }
        return "";
    }

    private boolean helper(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length(); 
    }
}
