class Solution {
    public int bitwiseComplement(int n) {
        
        String binary = Integer.toBinaryString(n);
        StringBuilder flipped = new StringBuilder();

        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '0'){
                flipped.append('1');
            }else{
                flipped.append('0');
            }
        }

        return Integer.parseInt(flipped.toString(), 2);
    }
}