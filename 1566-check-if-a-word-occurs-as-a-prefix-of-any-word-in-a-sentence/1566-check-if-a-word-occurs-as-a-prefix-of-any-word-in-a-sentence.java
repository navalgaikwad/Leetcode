class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for(int i=0; i<split.length; i++) {
            if(split[i].length() >= searchWord.length() && searchWord.equals(split[i].substring(0, searchWord.length()))) {
                return  i  + 1;
            }
        }
        return -1;
    }
}