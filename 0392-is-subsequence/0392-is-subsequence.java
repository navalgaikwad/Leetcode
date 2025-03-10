class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenOfS = s.length();
        int lenOfT = t.length();
        if(lenOfS == 0) return true;
        int index =0;
        for(int i=0; i<lenOfT; i++) {
            if(s.charAt(index) == t.charAt(i)) {
                index++;
                if(index == lenOfS) {
                    return true;
                }
            }
        }
        return false;
    }
}