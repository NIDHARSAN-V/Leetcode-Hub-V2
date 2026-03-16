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

            s.append(ch);

            if(check(s))
            {
                helper(res, s, n);
            }

            s.deleteCharAt(s.length() - 1);
        }
    }

    private boolean check(StringBuilder sb)
    {
        for(int i = 1; i < sb.length(); i++)
        {
            if(sb.charAt(i - 1) == sb.charAt(i))
            {
                return false;
            }
        }

        return true;
    }
}