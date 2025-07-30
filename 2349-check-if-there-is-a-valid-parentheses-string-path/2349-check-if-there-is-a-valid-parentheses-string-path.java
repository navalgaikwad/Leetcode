class Solution {
    public boolean hasValidPath(char[][] grid) {
        Boolean[][][] dp = new Boolean[grid.length][grid[0].length][210];
        return dfs(grid, grid.length - 1, grid[0].length - 1, 0, dp);
    }

    Boolean dfs(char[][] grid, int i, int j, int k, Boolean[][][] memo) {
        if (i < 0 || j < 0)
            return false;

        if (grid[i][j] == ')') {
            k++;
        } else {
            k--;
        }

        if (k < 0)
            return false;

        if (i == 0 && j == 0) {
            return k == 0;
        }
        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }
        Boolean up = dfs(grid, i - 1, j, k, memo);
        Boolean left = dfs(grid, i, j - 1, k, memo);

        memo[i][j][k] = up || left;
        return memo[i][j][k];
    }

}