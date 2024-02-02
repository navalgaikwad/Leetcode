class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<chars.length; ) {
            char c = chars[i];
            sb.append(c);
            int count  =0;
            while( i<chars.length && c == chars[i]) {
                i++;
                count++;
            }
            
            if(count>1) {
                
                sb.append(count);
            }
            
        }
        
        for(int i=0; i<sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}