class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0; // Edge case: empty matrix
        }
        int max = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols]; // DP array to store square sizes
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                int left = 0, above = 0, diag = 0;
                if(matrix[i][j] == '1') {
                    if( i > 0)  left = dp[i-1][j];
                    if( j > 0) above = dp[i][j-1];
                    if(i > 0 && j >0) diag = dp[i-1][j-1];

                    dp[i][j] = Math.min(left, Math.min(above, diag)) + 1;
                    max =Math.max(max, dp[i][j]);
                }
            }

        }
        return max * max;

    }

}
