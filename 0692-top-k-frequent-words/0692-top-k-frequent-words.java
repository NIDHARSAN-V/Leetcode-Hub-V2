class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }


        List<String> res = new ArrayList<>(freq.keySet());

        Collections.sort(res, (a, b) -> {
            int f = Integer.compare(freq.get(b), freq.get(a));
            if (f == 0) {
                return a.compareTo(b);
            }
            return f;
        });


        return res.subList(0, k);
    }
}
