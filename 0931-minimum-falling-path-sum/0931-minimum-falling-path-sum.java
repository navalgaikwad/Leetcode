import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Create a DP array with the same dimensions as the matrix
        int[][] dp = new int[m][n];

        // Initialize the first row of the DP array with the first row of the matrix
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        // Calculate the minimum falling path sum from the second row downwards
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start with a high value to find the minimum
                dp[i][j] = Integer.MAX_VALUE;

                // Check all possible previous positions (up, left-diagonal, right-diagonal)
                for (int k = -1; k <= 1; k++) { //direction
                    int prevCol = j + k;
                    if (prevCol >= 0 && prevCol < n) {
                        dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i - 1][prevCol]);
                    }
                }
            }
        }

        // Find the minimum value in the last row of the DP array
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

}
