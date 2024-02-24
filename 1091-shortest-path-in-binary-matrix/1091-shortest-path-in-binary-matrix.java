class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         if (grid[0][0] != 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
       // int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1, 1},{1,-1}};
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{1,-1}, {-1,1},{1,1},{-1,-1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0]= true;
        q.add(new int[]{0, 0, 1});
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];
            int level = current[2];
            
            if(i == m-1 && j == n-1) {
                return level;
            }
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==0 && !visited[x][y]) {
                    q.add(new int[]{x, y, level+1});
                    visited[x][y]= true;
                }
            }
        }
        return -1;
    }
}