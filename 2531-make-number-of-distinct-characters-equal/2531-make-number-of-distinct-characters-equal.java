class Solution {
    public boolean isItPossible(String word1, String word2) {

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }

        for (char c1 : m1.keySet()) {
            for (char c2 : m2.keySet()) {

                Map<Character, Integer> temp1 = new HashMap<>(m1);
                Map<Character, Integer> temp2 = new HashMap<>(m2);

                temp1.put(c1, temp1.get(c1) - 1);
                if (temp1.get(c1) == 0) temp1.remove(c1);

                temp1.put(c2, temp1.getOrDefault(c2, 0) + 1);

                temp2.put(c2, temp2.get(c2) - 1);
                if (temp2.get(c2) == 0) temp2.remove(c2);

                temp2.put(c1, temp2.getOrDefault(c1, 0) + 1);

                if (temp1.size() == temp2.size()) {
                    return true;
                }
            }
        }

        return false;
    }
}
