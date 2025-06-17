class Solution {
    private void rec(int i,String s,List<String> ds, List<List<String>> ans)
    {
        if(i==s.length())
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int j=i;j<s.length();j++)
        {
            if(isPalindrome(s,i,j))
            {
                ds.add(s.substring(i,j+1));
                rec(j+1,s,ds,ans);
                ds.remove(ds.size()-1);
            }
        }
        return;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        rec(0,s,ds,ans);
        return ans;
    }
    public boolean isPalindrome(String s,int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}