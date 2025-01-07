import java.util.*;

class Solution {
    public int ladderLength(String bw, String ew, List<String> wordList) {
        Set<String> s = new HashSet<>(wordList);
        if (!s.contains(ew)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(bw);

        int level = 1;

        while (!q.isEmpty()) {
            int lsize = q.size();

            while (lsize > 0) {
                String curr = q.poll();
                for (int i = 0; i < curr.length(); i++) {
                    char[] temp = curr.toCharArray(); // Use a character array for modifications
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        temp[i] = ch;
                        String dup = new String(temp);
                        if (dup.equals(curr)) {
                            continue;
                        }
                        if (dup.equals(ew)) {
                            return level + 1;
                        }
                        if (s.contains(dup)) {
                            q.add(dup);
                            s.remove(dup); // Avoid revisiting
                        }
                    }
                }
                lsize--;
            }
            level++;
        }

        return 0;
    }
}
