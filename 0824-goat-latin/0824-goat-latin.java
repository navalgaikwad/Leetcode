class Solution {
    public String toGoatLatin(String sentence) 
    {
        String vowels = "aeiouAEIOU";

        String[] words = sentence.split(" ");
        StringBuffer newSentence = new StringBuffer();
        int i = 1;

        for (String word : words)
        {
            char c = word.charAt(0);

            if (vowels.indexOf(c) != -1)
            {
                newSentence.append(word);
            }
            else
            {
                newSentence.append(word.substring(1));
                newSentence.append(c);
            }

            newSentence.append("ma");
            newSentence.append("a".repeat(i++));
            newSentence.append(" ");
        }    

        return newSentence.toString().substring(0, newSentence.length() - 1);
    }
}