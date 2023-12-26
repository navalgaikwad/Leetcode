class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int resultLength = 0;
        int len = s.length();
        for(int i =0; i<s.length(); i++) {
            int left = i;
            int right = i;
          //from each i check how much we can extend
            while(left>=0 && right< len && s.charAt(left)== s.charAt(right)) {
                 if(right - left + 1 > resultLength) {//need to find longest
                    result = s.substring(left, right+1);// update the longest 
                    resultLength = right - left + 1;
                }
                left--;
                right++;
            }
            
            left = i;
            right = i+1;
            while(left>=0 && right< len && s.charAt(left)== s.charAt(right)) {
                 if(right - left + 1 > resultLength) {//need to find longest
                    result = s.substring(left, right+1);// update the longest 
                    resultLength = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return result;
    }
}