class Solution {
    int total =0;
    int max=0;
    public int findMaxFish(int[][] grid) {
       int len = grid.length;
        for(int i=0;i<len; i++){
            for(int j=0;j<grid[0].length;j++){
               
                if(grid[i][j]!=0){
                    
                    
                   // System.out.print(total);
                    max =0;
                    dfs(i, j, grid);
                }
                 total=Math.max(total, max);
            }
        }
      return total;
    }
    
    void dfs(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return;
        }
        max=max+grid[i][j];
        grid[i][j]=0;
        
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        
        
        //grid[i][j] = temp;
        
    }
}