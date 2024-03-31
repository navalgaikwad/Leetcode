class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sCount = new int[200];
        int[] tCount = new int[200];
        for(int i=0; i<s.length(); i++) {
            if(sCount[s.charAt(i)] != tCount[t.charAt(i)]) {
                return false;
            }
            sCount[s.charAt(i)] = i + 1;
            tCount[t.charAt(i)] = i + 1;
        }
        return true;
    }
}