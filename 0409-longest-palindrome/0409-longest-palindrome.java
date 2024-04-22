class Solution {
    public int longestPalindrome(String s) {
        int oddNo = -1;
        int[] counts = new int[128];
        for(int i=0; i<s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        for(int count: counts) {
            if(count%2!=0) {
                oddNo++;
            }
        }
        return oddNo> 0? s.length() - oddNo : s.length();
    }
}
//abccccdd
//odd - len = 