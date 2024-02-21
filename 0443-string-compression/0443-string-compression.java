class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chars.length;i++) {
            char c = chars[i];
            int count =1;
            
            while(i + 1 < chars.length && c == chars[i + 1]) {
                count++;
                i++;
            }
            sb.append(c);
            
            if(count>1) {
               sb.append(count); 
            }
        }
        //System.out.print(sb.toString());
        int j =0;
        for(int i=0; i<sb.length();i++) {
            chars[i] = sb.charAt(i);
        }
        
        return sb.length();
    }
}

//["a","a","b","b","c","c","c"]
//a2
//b2