class Solution {
    public char findTheDifference(String s, String t) {
        int[] a = new int[26];
        for(char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            a[c - 'a']--;
        }
        for(int i=0; i<26 ;i++) {
            if( a[i] == -1) {
                return (char)(i + 'a');
            }
        }
        return ' ';
    }
}