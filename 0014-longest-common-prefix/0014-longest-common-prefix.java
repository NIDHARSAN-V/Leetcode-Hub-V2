class Solution {
    public String longestCommonPrefix(String[] strs) {
        // if (strs == null || strs.length == 0) {
        //     return "";
        // }
        // StringBuilder out = new StringBuilder();
        // int min = Integer.MAX_VALUE;
        // int mini = 0;
        // for (int i = 0; i < strs.length; i++) {
        //     if (strs[i].length() < min) {
        //         min = strs[i].length();
        //         mini = i;
        //     }
        // }

        // for (int x = 0; x < min; x++) {
        //     char c = strs[mini].charAt(x);
        //     for (int i = 0; i < strs.length; i++) {
        //         if (strs[i].charAt(x) != c) {
        //             return out.toString();
        //         }
        //     }
        //     out.append(c);
        // }

        // return out.toString();
        StringBuilder sc=new StringBuilder();
        int min=Integer.MAX_VALUE;
        int mini=0;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
                mini=i;
            }
        }
        for(int i=0;i<min;i++){
            char c=strs[mini].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=c){
                    return sc.toString();
                }
            }
            sc.append(c);
        }
        return sc.toString();
       
    }
}
