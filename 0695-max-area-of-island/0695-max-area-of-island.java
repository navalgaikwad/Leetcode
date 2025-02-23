class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
        return max_area;
    }
    
    public int AreaOfIsland(int[][] grid, int i, int j){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){ 
            return 0;
        }
            grid[i][j] = 0;
            int left = AreaOfIsland(grid, i+1, j);
            int right = AreaOfIsland(grid, i-1, j);
            int up = AreaOfIsland(grid, i, j-1);
            int down = AreaOfIsland(grid, i, j+1);
        
       return 1 + left + right + up + down;
    }
}