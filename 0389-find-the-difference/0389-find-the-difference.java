class Solution {
    public char findTheDifference(String s, String t) {
        int[] a = new int[26];
        
        // Increment the count for each character in string s
        for(char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        
        // Decrement the count for each character in string t
        for(char c : t.toCharArray()) {
            a[c - 'a']--;
        }
        
        // Find the character that has a count of -1
        for(int i = 0; i < 26; i++) {
            if (a[i] == -1) {
                return (char)(i + 'a');
            }
        }
        
        return ' ';
    }
}
