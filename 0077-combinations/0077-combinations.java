class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res  = new ArrayList<>();

        back(res , new ArrayList<>() ,1 ,n,k);
        return res;
    }

    public void back(List<List<Integer>> res , List<Integer> cur , int start , int n , int k)
    {
        if(cur.size()==k)
        {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i =start ; i<=n;i++)
        {
            cur.add(i);
            back(res , cur  , i+1,n,k);
            cur.remove(cur.size()-1);
        }
    }
}