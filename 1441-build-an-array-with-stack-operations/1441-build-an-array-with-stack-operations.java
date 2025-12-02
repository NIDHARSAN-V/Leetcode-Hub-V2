class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int ind = 0;
        for(int i=1;i<=n;i++){
            if(target[ind]==i){
                ind++;
                result.add("Push");
            }
            else{
                result.add("Push");
                result.add("Pop");
            }
            if(ind == target.length) break;
        }
        return result;
    }
}