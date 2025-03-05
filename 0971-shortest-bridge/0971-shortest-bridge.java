class Solution {
    Queue<int[]> q = new LinkedList<>();

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return;
        q.add(new int[] { i, j, 0 });
        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

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
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int x = current[0];
            int y = current[1];

            for (int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
                    if (grid[i][j] == 1) {
                        return current[2];
                    }
                    if (grid[i][j] == 0) {
                        grid[i][j] = -1;
                        q.add(new int[] { i, j, current[2] + 1 });

                    }
                }
            }
        }
        return 0;

    }
}