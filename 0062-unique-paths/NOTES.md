}
}
// Print the array for debugging
for (int i = 0; i < m; i++) {
for (int j = 0; j < n; j++) {
System.out.print(dp[i][j] + " "+ i+"_"+j+" ");
}
System.out.println();
}
return dp[0][n-1];
}
int dfs(int m, int n, HashMap<String, Integer> memo) {
if(memo.containsKey(m+"-"+n)) return memo.get(m+"-"+n);
if(m == 0 && n == 0) {
return 1;
}
if( m < 0 || n < 0) {
return 0;
}
int down  = dfs(m - 1, n, memo);
int right = dfs(m, n-1, memo);
int result = down + right;
memo.put(m+"-"+n, result);
return result;
}
}