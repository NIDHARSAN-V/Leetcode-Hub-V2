class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = 0;

        for (int i = 0; i < bank.length; i++) {
            int sum = 0;  

            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    sum++;
                }
            }

            if (sum > 0) {
                res += prev * sum;
                prev = sum;
            }
        }

        return res;
    }
}
