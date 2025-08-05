class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> targetFreq = new HashMap<>();

        
        for (char c : s.toCharArray()) {
            sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
        }

        
        for (char c : target.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;

        
        for (char c : targetFreq.keySet()) {
            if (!sFreq.containsKey(c)) {
                return 0;
            }
            min = Math.min(min, sFreq.get(c) / targetFreq.get(c));
        }

        return min;
    }
}
