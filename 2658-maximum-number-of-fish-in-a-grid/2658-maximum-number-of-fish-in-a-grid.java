class Solution {
    
    int total = 0;
    int max = 0;
    public int findMaxFish(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]!=0) {
                    max = dfs(grid, i, j);
                    total = Math.max(total, max);
                }
            }
        }
        return total;
    }
    
    int dfs(int[][] grid, int i, int j) {
        if(i <0 || i>=grid.length || j>=grid[0].length || j<0 || grid[i][j]==0) {
            return 0 ;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        temp +=dfs(grid, i + 1, j);
        temp +=dfs(grid, i, j + 1);
        temp +=dfs(grid, i, j - 1);
        temp +=dfs(grid, i - 1, j);
       
        return temp;
    }
}