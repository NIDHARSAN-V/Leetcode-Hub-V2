class Solution {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();

        for (int i = 3; i < sb.length(); i += 4) {
            sb.insert(i, '.');
        }

        sb.reverse();
        return sb.toString();
    }
}
