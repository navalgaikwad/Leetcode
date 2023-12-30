class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        Integer[][] memo = new Integer[m][n];

        //A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dfs(matrix, 0, j, memo));
        }

        return min;
    }
   //same as minimum path sum same condition
    //building from bottom to top 
    private int dfs(int[][] matrix, int i, int j, Integer[][] memo) {
        if (j < 0 || j >= matrix[0].length) { // correct condition for j 
            return Integer.MAX_VALUE;
        }

        if (i == matrix.length - 1) {// we going to the end
            return matrix[i][j];
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int down = dfs(matrix, i + 1, j, memo);
        int left = dfs(matrix, i + 1, j - 1, memo);
        int right = dfs(matrix, i + 1, j + 1, memo);

        memo[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));

        return memo[i][j];
    }
}
