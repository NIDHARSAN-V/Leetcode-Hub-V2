class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i = 1 ; i < s.length() ; i++)
        {
             if (i < 2 || !(s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2))) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
        
    }
}