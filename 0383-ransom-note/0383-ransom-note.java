class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       // int[] ransomNoteCount= new int[26];
        int[] magazineCount= new int[26];
        
        // for(char c: magazine.toCharArray()) {
        //     ransomNoteCount[c - 'a']++;
        // }
        for(char c: magazine.toCharArray()) {
            magazineCount[c - 'a']++;
        }
        
        for(char c: ransomNote.toCharArray()) {
             magazineCount[c - 'a']--;
            if(magazineCount[c - 'a'] < 0) {
                return false;
            }
            //magazineCount[c - 'a']--;
        }
        return true;
    }
}