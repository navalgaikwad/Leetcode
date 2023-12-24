class Solution {
    public int numEnclaves(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid.length == 1 || grid[0].length == 1) {
            return 0;
        }
        
        
        for(int i = 0; i<m; i++) {
            dfs(grid, i, 0); 
            dfs(grid, i, n - 1); 
        }
        
        for(int i = 0; i<n; i++) {
            dfs(grid, 0, i); 
            dfs(grid, m - 1, i); 
            
        }
         
        for(int i = 0 ;i < m; i++) {
            for(int j =0; j < n; j++) {
                if(grid[i][j] == 1) {
                    result++;
                }
            }
        }
       
        return result;
    }
   
    void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) {
            return;
        }
        grid[i][j] = 0;
        //visited[i][j] = true;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}

// 0 0 0 0 0 0 0 0 0 0 1
// 0 0 0 0 0 1 0 0 0 0 0 
// 0 0 0 0 0 0 0 0 0 0 0 
// 0 0 0 0 0 0 0 0 0 0 1 
// 0 0 0 0 0 0 0 0 1 0 0 
// 0 0 0 0 0 0 0 0 0 0 0 
// 0 0 0 0 0 0 0 0 1 0 0 
// 0 0 0 0 0 0 1 1 1 0 0 
// 0 0 0 0 0 0 0 0 0 0 0 
// 0 0 0 0 0 0 0 0 0 0 1 

// 0 0 0 0 0 0 0 0 0 0 0 
// 0 0 0 0 0 1 0 0 0 0 0 
// 0 0 0 0 0 0 0 0 0 1 0 
// 0 0 0 0 0 0 0 0 0 0 0 
// 0 0 0 0 0 0 0 0 1 0 0 
// 0 0 0 0 0 0 0 0 0 0 0 
// 0 0 0 0 0 0 0 0 1 0 0 
// 0 0 0 0 0 0 1 1 1 0 0 
// 0 0 0 0 0 0 0 0 0 0 0 
// 0 0 0 0 0 0 0 1 0 0 0 


//[
//[0,0,1,1,1,0,1,1,1,0,1],
//[1,1,1,1,0,1,0,1,1,0,0],
//[0,1,0,1,1,0,0,0,0,1,0],
//[1,0,1,1,1,1,1,0,0,0,1],
//[0,0,1,0,1,1,0,0,1,0,0],
//[1,0,0,1,1,1,0,0,0,1,1],
//[0,1,0,1,1,0,0,0,1,0,0],
//[0,1,1,0,1,0,1,1,1,0,0],
//[1,1,0,1,1,1,0,0,0,0,0],
//[1,0,1,1,0,0,0,1,0,0,1]]
