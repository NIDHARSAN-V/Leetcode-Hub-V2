class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int bitCompare = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
            if (bitCompare == 0) {
                return Integer.compare(a, b);
            }
            return bitCompare;
        });

        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
    }
}