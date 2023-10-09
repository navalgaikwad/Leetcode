class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int left=0;
        int right=0;
        int len = chars.length;
        int count =0;
        while(right < len){
            
            char c = chars[right];
            sb.append(c);
            count =0;
            while(right<len && chars[right] == c){
                count++;
                right++;
            }
            if(count>1){
              sb.append(count);  
            }
        }
        for (int i = 0; i < sb.length(); i++) {
           chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}