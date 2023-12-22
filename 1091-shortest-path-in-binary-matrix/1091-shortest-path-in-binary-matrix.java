class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        return bfs(grid, 0, 0);
    }
    
    boolean isValid(int[][] grid, int i, int j, boolean[][] visited) {
        int len = grid.length;
        return i >= 0 && i < len && j >= 0 && j < grid[0].length && !visited[i][j] && grid[i][j] == 0;
    }
    int bfs(int[][] grid, int i, int j) {
        int[][] direction = new int[][]{{0,-1}, {-1,0}, {1,1}, {-1, -1}, {1, 0}, {0, 1}, {-1, 1}, {1, -1}};
        
        int len = grid.length;
        
        boolean[][] visited = new  boolean[len][len];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{i, j, 1});
        visited[i][j] = true; //make sure to add visited true whenever you add value in the queue
        
        while(!q.isEmpty()) {
            
            int[] current = q.remove();
            
            int row = current[0];
            int col = current[1];
            int level =current[2];
            
            if(row == len - 1 && col == len - 1) {
                return level;
            }
            
            for(int[] dir : direction) {
                
                int newX = row + dir[0];
                int newY = col + dir[1];
                
                if(isValid(grid, newX, newY, visited)) {
                    visited[newX][newY] = true;
                    q.add(new int[]{newX, newY, level + 1});
                }
            }
        }
        return -1;
    }
}