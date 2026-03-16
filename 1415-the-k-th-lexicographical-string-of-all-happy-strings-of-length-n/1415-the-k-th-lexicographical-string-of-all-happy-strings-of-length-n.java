class Solution {

    public String getHappyString(int n, int k) {

        List<String> res = new ArrayList<>();

        helper(res, new StringBuilder(), n);

        if(k > res.size())
            return "";

        return res.get(k - 1);
    }

    private void helper(List<String> res, StringBuilder s, int n)
    {
        if(s.length() == n)
        {
            res.add(s.toString());
            return;
        }

        for(int i = 0; i < 3; i++)
        {
            char ch = (char)('a' + i);

            if(check(s, ch))
            {
                s.append(ch);
                helper(res, s, n);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    private boolean check(StringBuilder sb, char ch)
    {
        if(sb.length() == 0)
            return true;

        if(sb.charAt(sb.length() - 1) == ch)
            return false;

        return true;
    }
}