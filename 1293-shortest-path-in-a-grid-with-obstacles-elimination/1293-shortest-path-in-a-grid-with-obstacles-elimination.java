class Solution {
    public int shortestPath(int[][] grid, int k) {
        return bfs(grid, k);
    }
    
    int bfs(int[][] grid, int k) {
        int[][] directions = new int[][]{{1,0}, {0, 1}, { -1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k+1];
        visited[0][0][0] = true;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int row = current[0];
            int col = current[1];
            int level = current[2];
            int obs = current[3];
            if(row == m-1 && col == n-1 ) {
                return level;
            }
            // if(obs>k || visited[row][col][obs]){
            //     continue;
            //    }
            for(int[] dir: directions) {
                int x = row+dir[0];
                int y = col+dir[1];
                int obst = obs + (grid[row][col] == 1 ? 1 : 0);//add obscle in it
                
                if(x < m && x>=0 && y<n && y>=0 && obst<= k && !visited[x][y][obst]) {
                    q.add(new int[]{x, y, level+1, obst});
                    visited[x][y][obst]= true;
                }
            }
        }
        return -1;
    }
}