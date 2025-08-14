class Solution {
    public String largestGoodInteger(String num) {
        String largest = "";
        for (int i = 1; i < num.length() - 1; i++) {

            if (num.charAt(i - 1) == num.charAt(i) && num.charAt(i) == num.charAt(i + 1)) {

                String goodInteger = num.substring(i - 1, i + 2);

                if (largest.isEmpty() || goodInteger.compareTo(largest) > 0) {
                    largest = goodInteger;
                }
            }
        }
        return largest;
    }
}
