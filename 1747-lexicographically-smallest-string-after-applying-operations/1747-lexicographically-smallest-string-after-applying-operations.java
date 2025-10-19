class Solution {
    String result;

    public String findLexSmallestString(String s, int a, int b) {
        result = s;
        Set<String> visited = new HashSet<>();
        dfs(s, a, b, visited);
        return result;
    }

    private void dfs(String s, int a, int b, Set<String> visited) {
        if (visited.contains(s)) return; 
        visited.add(s);

        if (s.compareTo(result) < 0) result = s;

        dfs(addToOddIndices(s, a), a, b, visited);
        dfs(rotateRight(s, b), a, b, visited);
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
