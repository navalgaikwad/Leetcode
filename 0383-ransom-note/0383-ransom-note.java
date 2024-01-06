class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count1 = new int[26];
        
        for(char c : magazine.toCharArray()) {
            count1[c-'a']++;
        }
        
        for(char c: ransomNote.toCharArray()) {
            count1[c-'a']--;
            if(count1[c-'a'] < 0){
               return false; 
            }
        }
        return true;
    }
}