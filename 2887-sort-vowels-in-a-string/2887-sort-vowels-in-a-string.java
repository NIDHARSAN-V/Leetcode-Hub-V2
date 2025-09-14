class Solution {
    public String sortVowels(String s) {
        
        int[] freq = new int[52];
       
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                if (Character.isUpperCase(c)) {
                    freq[c - 'A']++;
                } else {
                    freq[c - 'a' + 26]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
              
                for (int i = 0; i < 52; i++) {
                    if (freq[i] > 0) {
                        char vowel;
                        if (i < 26) {
                            vowel = (char) ('A' + i);
                        } else {
                            vowel = (char) ('a' + i - 26);
                        }
                        sb.append(vowel);
                        freq[i]--;
                        break;
                    }
                }
            } else {
                sb.append(c); 
            }
        }
        
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
