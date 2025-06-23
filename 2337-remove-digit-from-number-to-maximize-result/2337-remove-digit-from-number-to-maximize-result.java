class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder res = new StringBuilder("0");
        for(int i=0;i<number.length();i++){
            char ch = number.charAt(i);
            if(ch == digit){
                StringBuilder sb = new StringBuilder(number);
                sb.deleteCharAt(i);
                if(sb.compareTo(res) > 0)
                    res = sb;
            }
        }
        return res.toString();
    }
}