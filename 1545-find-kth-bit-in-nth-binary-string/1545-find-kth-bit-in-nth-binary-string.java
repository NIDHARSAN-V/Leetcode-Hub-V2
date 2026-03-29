class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        return helper(n, k, sb);
    }

    private char helper(int n, int k, StringBuilder sb) {
        if (sb.length() >= k) {
            return sb.charAt(k - 1);
        }
        String original = sb.toString();

        sb.append("1").append(reverseString(new StringBuilder(original)));

        return helper(n, k, sb);
    }

    private String reverseString(StringBuilder sb) {
        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
            } else {
                sb.setCharAt(i, '0');
            }
        }

        return sb.toString();
    }
}