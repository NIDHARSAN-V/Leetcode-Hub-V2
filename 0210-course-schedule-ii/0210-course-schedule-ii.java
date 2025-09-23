class Solution {
    List<Integer> res = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> premap = new HashMap<>();

      
        for (int[] x : prerequisites) {
            premap.putIfAbsent(x[0], new ArrayList<>());
            premap.get(x[0]).add(x[1]);
        }

        int[] vis = new int[numCourses]; 

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, premap, vis)) {
                return new int[0];
            }
        }

       
       


        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, int[] vis) {
        if (vis[course] == 1) return false; 
        if (vis[course] == 2) return true;  

        vis[course] = 1;
        if (map.containsKey(course)) {
            for (int pre : map.get(course)) {
                if (!dfs(pre, map, vis)) {
                    return false;
                }
            }
        }

        res.add(course); 
        vis[course] = 2;  
        return true;
    }
}
