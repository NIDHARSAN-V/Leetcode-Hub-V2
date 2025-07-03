class Solution {
    public char kthCharacter(int k) {
        String s = "a";

        while (s.length() < k) {
            StringBuilder x = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'z') {
                    x.append('a');
                } else {
                    x.append((char)(c + 1));
                }
            }
            s += x.toString();
        }

        return s.charAt(k - 1);
    }
}
