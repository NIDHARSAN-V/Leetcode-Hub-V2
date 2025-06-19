class Solution {
    public String countAndSay(int n) {
        if(n==1)
        {
            return "1";
        }

        String res = "1";

        while( n  >  1)
        {
            res = form(res);
            n--;
        }

        return res;
    }

    private String form(String str)
    {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i = 1 ; i <str.length() ; i++)
        {
            if(str.charAt(i-1) == str.charAt(i))
            {
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(str.charAt(i-1));
                count = 1;
            }


            //for last one

        }
            sb.append(count);
            sb.append(str.charAt(str.length()-1));
            return sb.toString();
    }
}