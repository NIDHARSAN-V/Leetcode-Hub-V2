import java.util.*;

class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
       
        for (char c : chars.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        int totalLength = 0;

        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>(freqMap); 
            boolean canForm = true;

            for (char c : word.toCharArray()) {
                if (!tempMap.containsKey(c) || tempMap.get(c) == 0) {
                    canForm = false;
                    break;
                }
                tempMap.put(c, tempMap.get(c) - 1); 
            }

            if (canForm) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}
