class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int sum = 0, count = 0;

            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
                count++;

                
                if (count == k || i == s.length() - 1) {
                    sb.append(sum);
                    sum = 0;
                    count = 0;
                }
            }

            s = sb.toString();
        }

        return s;
    }
}
