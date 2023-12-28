class Solution {
    public int strStr(String haystack, String needle) {
        int left =0;
        int k = needle.length();
        for(int right =0;right<=haystack.length() - k; right++) {
            String sub = haystack.substring(left, right + k);
            if(checkIndex(sub, needle)) {
                return left;
            }
            left++;
        }
        return -1;
    }
    
    boolean checkIndex(String sub, String needle) {
        if(sub.equals(needle)) {
            return true;
        }
        return false;
    }
}