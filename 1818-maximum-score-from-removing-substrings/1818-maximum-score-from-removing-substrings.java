class Solution {

    int total = 0;

    public int maximumGain(String s, int x, int y) {
        if (x > y) {
           
            s = removePattern(s, 'a', 'b', x);
            s = removePattern(s, 'b', 'a', y);
        } else {
            
            s = removePattern(s, 'b', 'a', y);
            s = removePattern(s, 'a', 'b', x);
        }

        return total;
    }

    private String removePattern(String s, char first, char second, int score) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 2) == first && sb.charAt(len - 1) == second) {
                sb.delete(sb.length() - 2, sb.length());
                total += score;
            }
        }
        return sb.toString();
    }
}


    


  