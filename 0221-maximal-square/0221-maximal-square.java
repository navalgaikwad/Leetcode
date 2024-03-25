class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    dp[r + 1][c + 1] = Math.min(dp[r][c], Math.min(dp[r + 1][c], dp[r][c + 1])) + 1; // Be careful of the indexing since dp grid has additional row and column
                    maxSide = Math.max(maxSide, dp[r + 1][c + 1]);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}
