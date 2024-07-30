class Solution {
    public static boolean isPossibleToCutPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean firstUniquePathExists = dfs(n-1, m-1, grid);//if you reach to end from one side
        if (!firstUniquePathExists) return true;

        grid[n-1][m-1] = 1;
        boolean secondUniquePathExists = dfs(n-1, m-1, grid);
        return !secondUniquePathExists;
    }

    private static boolean dfs(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) return true;
        if (i < 0 || j < 0 || grid[i][j] == 0) return false;

        grid[i][j] = 0;
        return dfs(i-1, j, grid) || dfs(i, j-1, grid);
    }
}