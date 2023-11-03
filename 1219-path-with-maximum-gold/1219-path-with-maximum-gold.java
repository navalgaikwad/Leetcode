class Solution {
    int r = 0;
    int c = 0;
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return max;
    }
    
    private void dfs(int[][] grid, int i, int j, int cur) {
       // int sum=0;
      if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
         max= Math.max(max, cur);
          return;
      }
        int temp =grid[i][j];
         cur =cur+temp;
        grid[i][j]=0;
        dfs(grid, i+1, j, cur);
        dfs(grid, i-1, j, cur);
        dfs(grid, i, j+1, cur);
        dfs(grid, i, j-1, cur);
        grid[i][j]=temp;
    }
}