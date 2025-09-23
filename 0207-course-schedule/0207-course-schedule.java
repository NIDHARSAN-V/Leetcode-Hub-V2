class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> premap = new HashMap<>();

   
        for (int[] x : prerequisites) {
            premap.putIfAbsent(x[0], new ArrayList<>());
            premap.get(x[0]).add(x[1]);
        }

        int[] vis = new int[numCourses]; //0,1,2

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, premap, vis)) {
                return false; 
            }
        }
        return true;
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
        vis[course] = 2; 
        return true;
    }
}
