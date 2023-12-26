class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int maxLength = 0;
        int len = s.length();
        for(int i =0;i < s.length(); i++) {
            int left = i;
            int right = i;
            while( left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if(right - left+1  > maxLength) {
                   result = s.substring(left, right + 1);
                   maxLength = right - left + 1; 
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while(left >= 0  && right < len && s.charAt(left) == s.charAt(right)) {
                if(right - left +1  > maxLength) {
                   result =  s.substring(left, right + 1);
                   maxLength = right - left + 1; 
                }
                left--;
                right++;
            }
        }
        return result;
    }
}