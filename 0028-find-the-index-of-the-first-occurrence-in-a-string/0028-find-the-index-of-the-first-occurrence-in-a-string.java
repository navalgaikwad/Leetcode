class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        //sadbutsad
        //sad
        for(int i=0; i<=haystack.length()-len; i++) {
            if(needle.equals(haystack.substring(i, i + len))) {
                return i;
            }
        }
        return -1;
    }
}