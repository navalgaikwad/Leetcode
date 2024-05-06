class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenOfS = s.length();
        int lenOfT = t.length();
        if(lenOfS == 0) {
            return true;
        }
        int sIndex =0;
        for(int i=0; i<t.length(); i++) {
            if(s.charAt(sIndex) == t.charAt(i)) {
                sIndex++;
                if(sIndex == lenOfS) {
                return true;
                }
            }
            
        }
        return false;
    }
}