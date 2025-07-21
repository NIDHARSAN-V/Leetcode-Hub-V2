class Solution {
    public int countValidWords(String sentence) {
        sentence = sentence.trim().replaceAll("\\s+"," ");
        String[] words = sentence.split(" ");
        
        int count = 0;
        for(String word : words){
            if(word.matches("^([a-z]+(-?[a-z]+)?)?(!|\\.|,)?$")){
                count++;
            }
        }
        return count;
    }
}