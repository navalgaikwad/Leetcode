class Solution {
    public String longestPalindrome(String s) {
        String result="";
        int len =0;
        for(int k=0; k<s.length(); k++) {
            int left = k;
            int right = k;
            while(left >=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            left = k;
            right = k + 1;
             while(left >=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        
        return result;
    }
}