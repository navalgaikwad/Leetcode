class Solution {
    Integer[][] dp;
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new Integer[row][col];
        // for(int i=0; i<row; i++) {
        //     Arrays.fill(dp[i], 1);
        // }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == '1') {
                    int result = dfs(matrix, i, j);
                    ans = Math.max(result, ans);
                }
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans*ans; 
    }
    
    int dfs(char[][] matrix, int row, int col) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == '0') {
            return 0;
        }
        if(dp[row][col] != null) {
            return dp[row][col];
        }
        int min = 1 + Math.min(dfs(matrix, row + 1, col), Math.min(dfs(matrix, row, col + 1), 
                                                                  dfs(matrix, row + 1, col + 1)));
        dp[row][col] = min;
        return min;
    }
    
}