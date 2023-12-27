class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length()<=1){
            return 1;
        }
        String rev="";
        for(int i=0; i<s.length() ; i++){
            rev=s.charAt(i)+rev+"";
        }
        System.out.print(rev);
        return dp(s, rev, new HashMap<>(), s.length() - 1, rev.length() - 1);
    }
    
    
    int dp(String s, String t, Map<String, Integer> memo, int i, int j) {
        String key = i+"-"+j;
        if(i <0 || j<0) {
            return 0;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(s.charAt(i)==t.charAt(j)) {
            return 1 + dp(s, t, memo, i-1, j-1);
        }
        
        int result = Math.max(dp(s, t, memo, i-1, j),  dp(s, t, memo, i, j-1));
        memo.put(key, result);
        return result;
    }
}