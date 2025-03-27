class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }
        int[][] dirs= {{0,1}, {1, 0}, {-1, 0}, {0, -1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
       
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int x = current[0];
            int y = current[1];
            int level = current[2];
            if(x == m -1 && y == n-1) {
                return level;
            }
            for(int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if(i>=0 && i < m && j >=0 && j < n && grid[i][j]!=1 && !visited[i][j] ) {
                    q.add(new int[]{i, j, level  +1});
                    visited[i][j] = true;
                }
            }
        }
        return -1;
    }
}