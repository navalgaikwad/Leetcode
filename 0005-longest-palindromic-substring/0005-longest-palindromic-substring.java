class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int len =  s.length();
        int max  =0;
        for(int i =0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while( left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > max) {
                    max = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while( left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > max) {
                    max = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}