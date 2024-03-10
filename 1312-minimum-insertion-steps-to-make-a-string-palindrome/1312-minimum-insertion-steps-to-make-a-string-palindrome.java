class Solution {
    public int minInsertions(String s) {
        //String rev = "";
        String sb = "";
        for(int i=0;i<s.length(); i++) {
            sb =s.charAt(i)+sb+"";
        }
        int len = s.length();
        Integer[][] memo = new Integer[len][len];
        int value = helper(s, sb, len-1, len-1, memo);
        return len - value;
    }
    int helper(String s, String rev, int i, int j, Integer[][] memo) {
        if( i< 0 || j < 0) {
            return 0;
        }
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        int total = 0;
        if(s.charAt(i) == rev.charAt(j)) {
            total = 1 + helper(s, rev, i - 1, j -1, memo);
        }else {
            int top = helper(s, rev, i - 1, j, memo);
            int left = helper(s, rev, i, j-1, memo);
            total =Math.max(top, left);
        }
        memo[i][j] = total;
        return total;
    }
}