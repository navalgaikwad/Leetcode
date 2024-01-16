class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    int helper(String s, int i, int[] dp) {
        if(i == s.length()) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int minCuts = Integer.MAX_VALUE;
        for(int k = i; k< s.length(); k++) {
            if(isPalindrome(s, i, k)) {
                int count = helper(s, k + 1, dp);
                if( k != s.length() - 1 ) {
                    count = count + 1;
                }
                minCuts = Math.min(minCuts, count);
            }
        }
        dp[i] = minCuts;
        return minCuts;
    }
}