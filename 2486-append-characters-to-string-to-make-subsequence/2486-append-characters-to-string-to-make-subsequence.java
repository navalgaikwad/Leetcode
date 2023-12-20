class Solution {
    public int appendCharacters(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int j =0;
         for (int i = 0; i < len1 && j < len2; i++) {
            // Match the string
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return len2 - j;
    }
}
//it is straight forwar
//start from initial i and j check for match
//for matching increase the count