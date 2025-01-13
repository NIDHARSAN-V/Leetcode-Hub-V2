class Solution 
{
    public boolean areOccurrencesEqual(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return (set.size() == 1);
    }
}