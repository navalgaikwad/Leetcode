class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if(i >=row || i<0 || j>=col || j<0 || grid[i][j]=='0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}