class Solution {
    public String decodeString(String s) {
      Stack<StringBuilder> ch = new Stack<>();
      Stack<Integer> in = new Stack<>();
      StringBuilder sb = new StringBuilder();
      int n=0;
      for(char c : s.toCharArray())
      {
        if(Character.isDigit(c))
        {
            n = n*10 + (c-'0');
        }
        else if(c=='[')
        {
           in.push(n);
           n=0;
           ch.push(sb);
           sb = new StringBuilder();

        }
        else if(c==']')
        {
           int x = in.pop();
           StringBuilder temp = sb;
           sb = ch.pop();
           while(x-->0)
           {
             sb.append(temp);
           }

        }
        else
        {
            sb.append(c);
        }
      }
      return sb.toString();
    }
}