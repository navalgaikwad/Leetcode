class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        Integer[][] memo = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, memo, matrix[i][j] - 1));
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int i, int j, Integer[][] memo, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) {//vvimp
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int left = dfs(matrix, i + 1, j, memo, matrix[i][j]);
        int right = dfs(matrix, i, j + 1, memo, matrix[i][j]);
        int top = dfs(matrix, i - 1, j, memo, matrix[i][j]);
        int bottom = dfs(matrix, i, j - 1, memo, matrix[i][j]);
        memo[i][j] = 1 + Math.max(left, Math.max(right, Math.max(top, bottom)));
        return memo[i][j];
    }
}