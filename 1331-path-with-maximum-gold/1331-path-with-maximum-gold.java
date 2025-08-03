class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        int top = dfs(grid, i - 1, j);
        int bottom = dfs(grid, i, j - 1);
        int left = dfs(grid, i + 1, j);
        int right = dfs(grid, i, j + 1);
        grid[i][j] = temp;
        int max = grid[i][j] + Math.max(top, Math.max(bottom, Math.max(left, right)));
        return max;
    }
}