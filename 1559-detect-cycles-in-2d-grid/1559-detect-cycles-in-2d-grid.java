class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                  if(bfs(grid, i, j, visited)) {
                      return true;
                  }
                }
            }
        }
        
        return false;
    }
    
    boolean bfs(char[][] grid, int i, int j, boolean[][] visited) {
        char c = grid[i][j];
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int x = current[0];
            int y = current[1];
            if(visited[x][y]) {
                return true;
            }
            visited[x][y]=true;
            if(x-1>=0 && grid[x-1][y] == c && !(visited[x-1][y])) {
                q.add(new int[]{x-1, y});
            }
            if(y-1 >=0 && grid[x][y-1] == c && !(visited[x][y-1])) {
                q.add(new int[]{x, y-1});
            }
            if(x+1 <m && grid[x+1][y] == c && !(visited[x+1][y])) {
                q.add(new int[]{x+1, y});
            }
            if(y+1 <n && grid[x][y+1] == c && !(visited[x][y+1])) {
                q.add(new int[]{x, y+1});
            }
        }
        return false;
    }
}