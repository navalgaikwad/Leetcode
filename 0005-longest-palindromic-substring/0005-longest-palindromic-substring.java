class Solution {
    public String longestPalindrome(String s) {
          int len = 0;
        String result = "";
        for(int i=0; i<s.length(); i++) {
            int left =i;
            int right = i;
          
            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = Math.max(len, right - left + 1);//vvimp
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            } 
            left =i;
            right = i + 1;
            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = Math.max(len, right - left + 1);
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            } 
        }
        return result;
        
    }
}