class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int col = grid.length;
        int row = grid[0].length;
        int[][] dp = new int[col+1][row+1];
        dp[0][0] = 1; 
        for(int i = 0; i<col; i++) {
            for(int j = 0; j<row; j++) {
                if(grid[i][j]==1) {
                    dp[i][j] = 0;
                }else {
                    if(i-1 >= 0) {
                     dp[i][j]+= dp[i-1][j];   
                    }
                    if(j-1 >= 0) {
                     dp[i][j]+=dp[i][j-1];    
                    }
                }
                
            }
        }
        return dp[col-1][row-1];
    }
}
