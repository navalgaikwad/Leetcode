int helper(String s, String rev, int i, int j, Integer[][] memo) {
if (i < 0 || j < 0) {
return 0;
}
if (memo[i][j] != null) {
return memo[i][j];
}
if (s.charAt(i) == rev.charAt(j)) {
memo[i][j] = 1 + helper(s, rev, i - 1, j - 1, memo);
} else {
memo[i][j] = Math.max(helper(s, rev, i - 1, j, memo), helper(s, rev, i, j - 1, memo));
}
return memo[i][j];
}
​