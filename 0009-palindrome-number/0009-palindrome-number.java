class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        int n = c.length;
        for(int i=0; i<c.length/2; i++) {
            if(c[i]!=c[n-1-i]) {
                return false;
            }
        }
        return true;
    }
}