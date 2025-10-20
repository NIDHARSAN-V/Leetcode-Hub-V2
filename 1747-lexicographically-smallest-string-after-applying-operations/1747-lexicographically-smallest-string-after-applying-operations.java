import java.util.*;

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
        // If we already computed min for this string, return it
        if (dp.containsKey(s)) return dp.get(s);

        // If visited, return the string itself (avoid infinite recursion)
        if (visited.contains(s)) return s;

        visited.add(s);

        // Initialize current minimum as itself
        String minVal = s;

        // Operation 1: Add 'a' to odd indices
        String added = addToOddIndices(s, a);
        String min1 = dfs(added, a, b, visited);
        if (min1.compareTo(minVal) < 0) minVal = min1;

        // Operation 2: Rotate right by b
        String rotated = rotateRight(s, b);
        String min2 = dfs(rotated, a, b, visited);
        if (min2.compareTo(minVal) < 0) minVal = min2;

        // Update global result
        if (minVal.compareTo(result) < 0) result = minVal;

        // Store in dp
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
