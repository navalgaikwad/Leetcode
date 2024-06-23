import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid, int i, int j) {
        int[] directions = {0, 1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0'; // mark as visited

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int d = 0; d < 4; d++) {
                int newRow = row + directions[d];
                int newCol = col + directions[d + 1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // mark as visited
                }
            }
        }
    }
}
