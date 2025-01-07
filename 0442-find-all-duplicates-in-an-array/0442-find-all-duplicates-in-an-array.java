import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();
        
     
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        
        return duplicates;
    }
}
