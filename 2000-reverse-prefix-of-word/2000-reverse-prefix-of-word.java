class Solution {
    public String reversePrefix(String word, char ch) {
         int ind = word.indexOf(ch);
        StringBuilder str = new StringBuilder();
        for(int i=0; i<=ind; i++){
            str.append(word.charAt(i));
        }
        str.reverse();
        String sb = word.substring(ind+1);
        return str.toString()+sb;
    }
}