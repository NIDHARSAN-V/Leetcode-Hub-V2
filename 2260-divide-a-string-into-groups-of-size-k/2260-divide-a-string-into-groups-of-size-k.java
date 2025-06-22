class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        StringBuilder res = new StringBuilder(s);
        
  
        int rem = s.length() % k;
        if (rem != 0) {
            for (int i = 0; i < k - rem; i++) {
                res.append(fill);
            }
        }

        int n = res.length() / k;
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = res.substring(i * k, (i + 1) * k);
        }

        return str;
    }
}
