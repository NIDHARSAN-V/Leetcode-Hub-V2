class Solution {
    public int secondHighest(String s) {
        Set<Integer> set = new TreeSet<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(c - '0'); 
            }
        }

        if (set.size() < 2) {
            return -1;
        }

        
        ((TreeSet<Integer>) set).pollLast();
        return ((TreeSet<Integer>) set).last(); 
    }
}
