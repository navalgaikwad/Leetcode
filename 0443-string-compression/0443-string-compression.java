class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chars.length; i++) {
            int count = 1;
            char c = chars[i];
            while( i + 1< chars.length && c == chars[i + 1]) {
                i++;
                count++;
            }
            sb.append(c);
            if(count > 1) {
                sb.append(count);
            }
           
        }
         int j =0;
            for(int i=0; i<sb.length();i++) {
                chars[i] = sb.charAt(i);
            } 
        return sb.length();
    }
}