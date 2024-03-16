class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev ="";
        for(int i = 0; i<s.length(); i++) {
            rev = s.charAt(i) + rev;
        }
        Integer[][] memo = new Integer[s.length()][s.length()];
       // System.out.print(rev);
        return helper(s.length() - 1, s.length() - 1, s, rev, memo);
    }
    
    int helper(int i, int j, String s, String rev, Integer[][] memo) {
        if( i < 0) {
            return 0;
        }
        if(j < 0) {
            return 0;
        }
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        int total = 0;
        if(s.charAt(i) == rev.charAt(j)) {
            total = 1 + helper(i - 1, j - 1, s, rev, memo);
        }else {
            int one = helper(i , j - 1, s, rev, memo);
            int two = helper(i - 1, j, s, rev, memo);
            total = Math.max(one, two);
        }
        memo[i][j] = total;
        return total;
    }
}