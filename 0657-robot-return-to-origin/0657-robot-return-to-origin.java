class Solution {
    public boolean judgeCircle(String moves) {
        Stack<Character> ud = new Stack<>(); 
        Stack<Character> lr = new Stack<>();

        for (char move : moves.toCharArray()) {

            if (move == 'U') {
                if (!ud.isEmpty() && ud.peek() == 'D') ud.pop();
                else ud.push('U');
            } 
            else if (move == 'D') {
                if (!ud.isEmpty() && ud.peek() == 'U') ud.pop();
                else ud.push('D');
            }
            else if (move == 'L') {
                if (!lr.isEmpty() && lr.peek() == 'R') lr.pop();
                else lr.push('L');
            } 
            else if (move == 'R') {
                if (!lr.isEmpty() && lr.peek() == 'L') lr.pop();
                else lr.push('R');
            }
        }

        return ud.isEmpty() && lr.isEmpty();
    }
}