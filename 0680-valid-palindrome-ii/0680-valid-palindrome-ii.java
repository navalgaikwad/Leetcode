class Solution {
    public boolean validPalindrome(String s) {
        int st = 0;
        int e = s.length()-1;
        while(st < e) {
            if(s.charAt(st) != s.charAt(e)) {
                return palindrome(s, st+1, e) || palindrome(s, st, e-1);
            }
            st++;
            e--;
        }
        return true;
        
    }

    boolean palindrome(String st, int s, int e) {
        while(s<=e) {
            if(st.charAt(s) != st.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}