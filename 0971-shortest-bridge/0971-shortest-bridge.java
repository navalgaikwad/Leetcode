class Solution {
    Queue<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    break;
                }
            }
        }
        dfs(grid, startI, startJ);
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int i = current[0];
            int j = current[1];
            int level = current[2];
            for (int[] dir : dirs) {
                int m = i + dir[0];
                int n = j + dir[1];

                if (m >= 0 && m < grid.length && n >= 0 && n < grid[0].length) {
                    if (grid[m][n] == 1) {
                        return level;
                    }
                    if (grid[m][n] == 0) {
                        grid[m][n] = -2;
                        queue.add(new int[] { m, n, level + 1 });
                    }
                }
            }
        }
        return 0;

    }

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -2 || grid[i][j] == 0) {//vvimp
            return;
        }
        queue.add(new int[] { i, j, 0 });
        grid[i][j] = -2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}