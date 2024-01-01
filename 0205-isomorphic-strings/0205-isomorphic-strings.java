class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[200];
        int[] tArray = new int[200];
        int i =0;
        int len = s.length();
        int j=0;
        while(i < len) {
            if(sArray[s.charAt(i)] != tArray[t.charAt(i)]){
                return false;
            }
            sArray[s.charAt(i)] = i+1;
            tArray[t.charAt(i)] = i+1;
            i++;
        }
        return true;
    }
}