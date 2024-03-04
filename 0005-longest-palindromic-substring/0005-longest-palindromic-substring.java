class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        String result = "";
        for(int i=0; i<s.length(); i++) {
            int left = i;
            int right = i;
            
            while(left >=0 && right < len && s.charAt(left)==s.charAt(right)) {
                
                if(right - left + 1 > max) {
                   result=s.substring(left, right+1);
                   max =  right - left + 1;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while(left >=0 && right < len && s.charAt(left)==s.charAt(right)) {
                
                if( right - left + 1 > max) {
                   result=s.substring(left, right + 1);
                   max =  right - left + 1;
                }
                left--;
                right++;
            }
            
        }
        return result;
    }
}