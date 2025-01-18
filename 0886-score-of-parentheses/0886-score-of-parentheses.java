class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for(char c : s.toCharArray())
        {
            if(c=='(')
            {
                stk.push(res);
                res = 0;
            }
            else
            {
                res = stk.pop() + Math.max(2*res , 1);
            }
        }
        return res;
    }
   
}