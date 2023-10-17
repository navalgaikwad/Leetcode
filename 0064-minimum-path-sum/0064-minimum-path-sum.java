class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp =new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
            
                if(i-1>=0 && j-1 >= 0){
                int min = Math.min(dp[i][j-1]+ grid[i][j], dp[i-1][j]+ grid[i][j]);
                dp[i][j] = min;   
                }else if(i-1 >= 0){
                   dp[i][j] = dp[i-1][j]+grid[i][j];     
                }else if(j-1 >= 0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];     
                }  
            }
        }
        return dp[row-1][col-1];
    }
}