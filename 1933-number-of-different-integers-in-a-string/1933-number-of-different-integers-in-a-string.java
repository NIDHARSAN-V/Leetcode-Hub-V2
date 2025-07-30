class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int i = 0;
        int n = word.length();

        while (i < n) {
            if (Character.isDigit(word.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                while (i < n && word.charAt(i) == '0') {
                    i++;
                }
              
                while (i < n && Character.isDigit(word.charAt(i))) {
                    sb.append(word.charAt(i));
                    i++;
                }
                
                set.add(sb.length() == 0 ? "0" : sb.toString());
            } else {
                i++;
            }
        }

        return set.size();
    }
}
