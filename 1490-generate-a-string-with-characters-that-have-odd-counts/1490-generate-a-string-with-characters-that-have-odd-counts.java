class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        int x = 0;

        if((n%2) == 0 )
        {
           x=1;
        }
        for(int i =0 ; i < n-x ; i++)
        {
            sb.append('a');
        }
        return x==1 ? sb.toString()+'z' : sb.toString();
    }
}