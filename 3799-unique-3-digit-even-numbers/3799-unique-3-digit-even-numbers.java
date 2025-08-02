class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> hs = new HashSet<>();
        int n = digits.length;
        for(int i = 0;i<n;i++){
            if(digits[i] == 0){continue;}
            for(int j =0;j<n;j++){
                if(i == j){continue;}
                for (int k = 0; k<n; k++){
                    if(i == k||j == k)continue;
                    if(digits[k]%2 == 0){
                        StringBuilder sb = new StringBuilder();
                        sb.append(digits[i]);
                        sb.append(digits[j]);
                        sb.append(digits[k]);
                        int num = Integer.parseInt(sb.toString());
                        hs.add(num);
                    }
                }
            }
        }
        return hs.size();
    }
}