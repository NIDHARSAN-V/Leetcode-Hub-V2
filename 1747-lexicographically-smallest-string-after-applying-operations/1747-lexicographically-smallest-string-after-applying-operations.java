class Solution {
    String result;
    Map<String, String> dp = new HashMap<>();

    public String findLexSmallestString(String s, int a, int b) {
        result = s;
        Set<String> visited = new HashSet<>();
        dfs(s, a, b, visited);
        return result;
    }

    private String dfs(String s, int a, int b, Set<String> visited) {
        
        if (dp.containsKey(s)) return dp.get(s);

        
        if (visited.contains(s)) return s;

        visited.add(s);

      
        String minVal = s;

        String added = addToOddIndices(s, a);
        String min1 = dfs(added, a, b, visited);
        if (min1.compareTo(minVal) < 0) minVal = min1;

        String rotated = rotateRight(s, b);
        String min2 = dfs(rotated, a, b, visited);
        if (min2.compareTo(minVal) < 0) minVal = min2;

       
        if (minVal.compareTo(result) < 0) result = minVal;

        
        dp.put(s, minVal);
        return minVal;
    }

    private String addToOddIndices(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int num = (arr[i] - '0' + a) % 10;
            arr[i] = (char) (num + '0');
        }
        return new String(arr);
    }

    private String rotateRight(String s, int b) {
        int n = s.length();
        b %= n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
