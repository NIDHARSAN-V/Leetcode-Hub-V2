class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        helper(tiles, res, new StringBuilder(), visited);
        return res.size();
    }

    private void helper(String tiles, Set<String> res, StringBuilder sb, boolean[] vis) {

        for(int i = 0 ; i <tiles.length() ;i++)
        {
            
            if(vis[i])
            {
                continue;
            }

            if (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1) && !vis[i - 1]) 
                continue;

            sb.append(tiles.charAt(i));


            vis[i]= true;
            res.add(sb.toString());

            helper(tiles ,  res, sb , vis );
            
            vis[i]=  false;
            sb.deleteCharAt(sb.length() - 1);
        }   
 }
}