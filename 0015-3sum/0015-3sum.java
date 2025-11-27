class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
         Set<List<Integer>> ans = new HashSet<>();
         int n = arr.length;
        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Set to store elements seen in this iteration
            Set<Integer> hashset = new HashSet<>();

            // Second loop for second element
            for (int j = i + 1; j < n; j++) {
                // Calculate third element needed
                int third = -(arr[i] + arr[j]);

                // If third already in set, we found a triplet
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }

               
                hashset.add(arr[j]);
            }
        }

        return new ArrayList<>(ans);
    }
}