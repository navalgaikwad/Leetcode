class Solution {
    public String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        StringBuffer sb = new StringBuffer();
        int i=1;
        String[] split = sentence.split(" ");
        for(String word : split) {
            char c = word.charAt(0);
            if(vowels.indexOf(c) != -1) {
                sb.append(word);
            }else {
                sb.append(word.substring(1));
                sb.append(c);
            }

            sb.append("ma");
            sb.append("a".repeat(i++));
            sb.append(" ");


        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}