class Solution {
    public boolean isSubsequence(String s, String t) {
        int len = s.length();
        int lent = t.length();
        if(len == 0) {
            return true;
        }
        int indexS = 0; int indexT = 0;
        while(indexT < lent) {
            if(s.charAt(indexS)== t.charAt(indexT)) {
                indexS++;
                if(indexS == len) {
                    return true;
                }
            }
            indexT++;
        }
        return false;
    }
}