class Solution {

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int closedIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)) res++;
                }
            }
        }
        
        return res;
    }
    
    public boolean dfs(int[][] grid, int x, int y){
        
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        
        if(grid[x][y] == 1) return true;
        
        grid[x][y] = 1;
        
        boolean res = true;
        
       
        boolean top = dfs(grid, x + 1, y );
        boolean botttom = dfs(grid, x , y + 1);
        boolean right = dfs(grid, x - 1, y );
        boolean left = dfs(grid, x, y - 1);
       
        
        return top&&botttom&&right&&left;
    }
}

