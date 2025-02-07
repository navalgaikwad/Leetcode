class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            if(needle.equals(haystack.substring(i, needle.length() + i))) {
                return i;
            }
        }
        return -1;
    }
}