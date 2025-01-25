class Solution {
    public String compressedString(String word) {
        if(word.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char[] ch = word.toCharArray();
        int count = 1;
        for(int i=0; i<ch.length; i++) {
            char c = ch[i];
            while(i+1<ch.length && ch[i+1] == c && count!=9) {
                count++;
                i++;
            }
            String value = count+""+c;
            sb.append(value);
            count = 1;
        }
        return sb.toString();
        
    }
}