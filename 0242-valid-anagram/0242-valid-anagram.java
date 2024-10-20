class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[26];
       
        
        for(char c : s.toCharArray()) {
            sArray[c-'a']++;
        }
        for(char c : t.toCharArray()) {
            if(sArray[c-'a'] == 0) {
                return false;
            }
            sArray[c-'a']--;
        }
        return true;
    }
}