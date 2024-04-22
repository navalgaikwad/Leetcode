class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] counts = new int[26];
        for(char c : s.toCharArray()) {
            counts[c- 'a']++;
        }
        int frequency = counts[s.charAt(0) - 'a'];
        for(int i =0; i<s.length(); i++) {
            if(counts[s.charAt(i) - 'a'] != frequency) {
                return false;
            }
        }
        return true;
    }
}