class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int result =0;
        for(int i =0; i<len; i++) {
           int left = i;
           int right = i;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)) {
                result++; 
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)) {
                result++; 
                left--;
                right++;
            }
        }
        return result;
    }
}