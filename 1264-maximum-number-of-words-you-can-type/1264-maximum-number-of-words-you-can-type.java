class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
         String[] words = text.split(" ");
         int c = 0;
         for(String word : words)
         {

            for(char ch  : brokenLetters.toCharArray() )
            {
                if(word.contains(String.valueOf(ch)))
                {
                   c++;
                   break;
                }
            }
         }

         return words.length - c;
    }
}