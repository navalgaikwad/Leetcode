class Solution {
    public String longestPalindrome(String s) {
        String result ="";
        int maxResult =0;
        int len = s.length();
        for(int i =0; i<len; i++) {
            int left = i;
            int right =i;
            while(left >=0 && right<len && s.charAt(left)==s.charAt(right)) {
                if(right -left+1 > maxResult){
                    maxResult = right -left+1;
                    result= s.substring(left, right+1);
                }
                left--;
                right++;
            }
             left = i;
             right =i+1;
            while(left >=0 && right<len && s.charAt(left)==s.charAt(right)) {
                if(right -left+1 > maxResult){
                    maxResult = right -left +1;
                    result= s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        return result;
    }
}