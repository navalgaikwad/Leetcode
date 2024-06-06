class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenOfS =s.length();
        int lenOft =t.length();
        if(lenOfS == 0) return true;
        int index = 0;
        for(int i=0; i<lenOft; i++) {
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