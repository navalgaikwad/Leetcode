class Solution {
    int[][] dp;
    
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    ans = Math.max(ans, helperMethod(i, j, matrix));
                }
            }
        }
        
        return ans == Integer.MIN_VALUE ? 0 : ans * ans;
    }
    
    private int helperMethod(int i, int j, char[][] matrix) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        return dp[i][j] = 1 + Math.min(helperMethod(i + 1, j, matrix), Math.min(helperMethod(i + 1, j + 1, matrix),
                            helperMethod(i, j + 1, matrix)));
    }
}

// i+1. j+1
// i+1, j
// i, j+1
