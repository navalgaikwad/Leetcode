class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[26];
        for(int i = 0; i<s.length(); i++) {
            sArray[s.charAt(i)- 'a']++;
        }
        
        for(int tA : t.toCharArray()) {
            if(sArray[tA - 'a'] == 0) {
                return false;
            }
            sArray[tA - 'a']--;
        }
        
        return true;
    }
    
}