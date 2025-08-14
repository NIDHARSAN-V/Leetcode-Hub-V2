class Solution {
    public String minRemoveToMakeValid(String s) {



        int count  =0 ;


        Stack<Integer> stk = new Stack<>();
        boolean[] vis = new boolean[s.length()];

        for(int i  =0  ; i < s.length() ; i++)
        {
            if(s.charAt(i) == '(')
            {
                stk.push(i);
            }
            else if(s.charAt(i) == ')')
            {
                if(!stk.isEmpty())
                {
                    stk.pop();
                }
                else
                {
                     vis[i] = true;
                }
            }
        }


        while(!stk.isEmpty())
        {
           vis[stk.pop()] = true;
        }



        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length() ;i++)
        {
            if(!vis[i])
            {
                sb.append(s.charAt(i));
            }
        }


        return sb.toString();

        
    }
}