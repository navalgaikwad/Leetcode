class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
         if(s.length()<=1){
            return 1;
        }
        String rev="";
        for(int i=0; i<s.length() ; i++){
            rev=s.charAt(i)+rev+"";
        }
        return helper(s, rev, rev.length()-1, rev.length()-1, memo);
        
    }
    
    int helper(String s, String rev, int i, int j, Integer[][] memo) {
        if(i <0) {
            return 0;
        }
        if(j <0) {
            return 0;
        }
        if(memo[i][j]!=null) {
            return memo[i][j];
        }
        int total =0;
        if(s.charAt(i) == rev.charAt(j)) {
          total =1+ helper(s,rev, i-1, j-1, memo);  
        }else {
            int top = helper(s,rev, i-1, j, memo);
            int right = helper(s,rev, i, j-1, memo);
            total =Math.max(top, right);
        }
        memo[i][j]= total;
        return total;
    }
}