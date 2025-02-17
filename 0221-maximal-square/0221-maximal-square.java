class Solution {
    public int maximalSquare(char[][] matrix) {
          if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0; // Edge case: empty matrix
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols]; // DP array to store square sizes
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') { // Only consider '1' cells
                    int left = (i > 0) ? dp[i - 1][j] : 0;
                    int above = (j > 0) ? dp[i][j - 1] : 0;
                    int diag = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;

                    dp[i][j] = Math.min(left, Math.min(above, diag)) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide * maxSide; // Return the area of the largest square
    }
}

