class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String word : logs) {
            if (word.equals("../")) {
                if (depth > 0) depth--; 
            } else if (!word.equals("./")) {
                depth++;
            }
        }

        return depth;
    }
}
