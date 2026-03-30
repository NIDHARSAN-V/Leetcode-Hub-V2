
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();

        StringBuilder s1_even = new StringBuilder();
        StringBuilder s1_odd  = new StringBuilder();
        StringBuilder s2_even = new StringBuilder();
        StringBuilder s2_odd  = new StringBuilder();

    
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s1_even.append(s1.charAt(i));
                s2_even.append(s2.charAt(i));
            } else {
                s1_odd.append(s1.charAt(i));
                s2_odd.append(s2.charAt(i));
            }
        }

     
        char[] a1 = s1_even.toString().toCharArray();
        char[] a2 = s2_even.toString().toCharArray();
        char[] b1 = s1_odd.toString().toCharArray();
        char[] b2 = s2_odd.toString().toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);
        Arrays.sort(b1);
        Arrays.sort(b2);

    
        return Arrays.equals(a1, a2) && Arrays.equals(b1, b2);
    }
}