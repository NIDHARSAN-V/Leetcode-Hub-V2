class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer , Integer> res = new HashMap<>();
        int count =0;
        
        prefixhelper(wall);

        for(List<Integer> li: wall )
        {
            for(int i = 0 ; i < li.size()-1 ; i++)
            {
                res.put( li.get(i) , res.getOrDefault(li.get(i) , 0)  +1);
                count = Math.max(res.get(li.get(i)) , count);
            }
        }
        return Math.abs(count - wall.size());


        
    }


    private void prefixhelper(List<List<Integer>> lists) {
        for (List<Integer> sublist : lists) {
            for (int i = 1; i < sublist.size(); i++) {
                sublist.set(i, sublist.get(i) + sublist.get(i - 1));
            }
        }
    }
}