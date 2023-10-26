class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
       
        dp[0][0] = 1;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==1){
                 dp[i][j] =0; 
                }else{
                    if( i+1<row ){
                    dp[i+1][j] +=  dp[i][j];
                } if(j +1<col){
                     dp[i][j+1] +=  dp[i][j];
                }
              }
            }
        }
        return dp[row-1][col-1];
    }
}