class Solution {
    public boolean isAnagram(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        if(m!=n) return false;
        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for(int i=0; i<n; i++) {
            sArray[s.charAt(i) - 'a']++;
            tArray[t.charAt(i) - 'a']++;
        }
        for(int i=0; i<m; i++) {
           if(sArray[s.charAt(i) - 'a'] != tArray[s.charAt(i) - 'a']) {
            return false;
           }
        }
        return true;
    }
    //count freq int[]
}