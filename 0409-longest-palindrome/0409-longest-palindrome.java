class Solution {
    public int longestPalindrome(String s) {
        int oddNo = -1;
        int[] count = new int[128];
        int ans =0;
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for(int i =0; i<128; i++) {
            if(count[i]%2!=0) {
                oddNo++;
            }
        }
        return oddNo>0? s.length() - oddNo : s.length();
    }
}
//128