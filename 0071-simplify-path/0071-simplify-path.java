class Solution {
    public String simplifyPath(String path) {
       Stack<String> stk = new Stack<>();
       StringBuilder res  =  new StringBuilder();
       String[] p = path.split("/");

       for(int i =0 ; i < p.length ; i++)
       {
         if(!stk.isEmpty() && p[i].equals(".."))
         { 
             stk.pop();
         }
         else if(!p[i].equals(".") && !p[i].equals("..") && !p[i].equals("") )
         {
            stk.push(p[i]);
         }
       }
       if(stk.isEmpty())
       {
         return "/";
       }
        while (!stk.isEmpty()) {
            res.insert(0, stk.pop()).insert(0, "/");
        }
       return res.toString();
       
    }
}