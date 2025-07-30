import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<String> memo = new HashSet<>(); 

        for (int i = arr.length - 1; i >= 0; i--) {
            helper(arr, i, set, 0, memo);
        }

        return set.size();
    }

    private void helper(int[] arr, int index, Set<Integer> set, int or, Set<String> memo) {
        if (index >= arr.length) return;

        or |= arr[index];

       
        String key = index + "#" + or;
        if (memo.contains(key)) return;
        memo.add(key);

        set.add(or);

        helper(arr, index + 1, set, or, memo);
    }
}
