class Solution {
    public String longestPalindrome(String s) {
        String result ="";
        int resultLength = 0;
        int len = s.length();
        for(int i =0; i < len; i++) {
            int left = i;
            int right = i;
            //odd size
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > resultLength) {//need to find longest
                    result = s.substring(left, right+1);
                    resultLength = right - left + 1;
                }
                left--;
                right++;
            }
            //even side
            left = i; 
            right = i + 1; //character might even for odd so need to check for both
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
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
//no of subtring n*n -1 //2 so brute force it takes O(n3)
//1. Take one charatcer and check in i and j side, do we maximum value lenght
//2. check for even side
//3. check for odd side
//4. return the result who ever gives best answer give it