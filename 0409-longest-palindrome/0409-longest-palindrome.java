class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[200];
        for(char c :s.toCharArray()) {
            counts[c]++;
        }
        int oddCount = -1;
        for(int count: counts) {
            if(count%2!=0) {
                oddCount++;
            }
        }
        return oddCount > 0 ? s.length() - oddCount : s.length();
    }
}