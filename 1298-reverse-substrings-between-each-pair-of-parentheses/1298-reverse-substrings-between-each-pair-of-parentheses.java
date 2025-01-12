class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i =0;
        

        while(i < s.length())
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                stack.push(String.valueOf(ch));
            }
            else if(ch==')')
            {
                 
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                   temp.append(new StringBuilder(stack.pop()).reverse());
                }

               
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                }
                // System.out.println(temp.toString());

                stack.push(temp.toString());
            }
            else
            {
                stack.push(String.valueOf(ch));
            }
            i++;
        }
        System.out.print(stack);
      StringBuilder result = new StringBuilder();
while (!stack.isEmpty()) {
    result.insert(0, stack.pop().toString());
}
return result.toString();

     

    }
}