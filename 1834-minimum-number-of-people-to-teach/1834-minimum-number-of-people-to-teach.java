class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer , List<Integer>> user = new HashMap<>();
        for(int i = 0 ; i < languages.length ; i++ )
        {
            List<Integer> li = new ArrayList<>();
            for(int x : languages[i])
            {
                li.add(x);
            }
            user.put(i+1 , li);
        }

        System.out.print(user);
        List<int[]> uncommon = new ArrayList<>();
       

        for (int[] pair : friendships) {
            int u = pair[0];
            int v = pair[1];
            List<Integer> uLangs = user.get(u);
            List<Integer> vLangs = user.get(v);
            boolean common = false;
            for (int lang : uLangs) {
                if (vLangs.contains(lang)) {
                    common = true;
                    break;
                }
            }
            if (!common) {
                uncommon.add(new int[]{u, v});
            }
        }


        int minTeach = Integer.MAX_VALUE;

        for (int lang = 1; lang <= n; lang++) {
            Set<Integer> teach = new HashSet<>();
            for (int[] pair : uncommon) {
                int u = pair[0];
                int v = pair[1];
                if (!user.get(u).contains(lang)) {
                    teach.add(u);
                }
                if (!user.get(v).contains(lang)) {
                    teach.add(v);
                }
            }
            minTeach = Math.min(minTeach, teach.size());
        }


        return minTeach;

    }
}