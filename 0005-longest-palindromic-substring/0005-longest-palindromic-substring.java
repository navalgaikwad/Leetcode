class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        int start = 0, end = 0;
        Boolean[][] palindromeMemo = new Boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (palindrome(j, i, s, palindromeMemo)) {
                    if (i - j > end - start) {
                        start = j;
                        end = i;
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    boolean palindrome(int start, int end, String s, Boolean[][] palindromeMemo) {
        if (start >= end) return true;
        if (palindromeMemo[start][end] != null) {
            return palindromeMemo[start][end];
        }
        
        if (s.charAt(start) == s.charAt(end)) {
            palindromeMemo[start][end] = palindrome(start + 1, end - 1, s, palindromeMemo);
            return palindromeMemo[start][end];
        }
        
        palindromeMemo[start][end] = false;
        return false;
    }
}
