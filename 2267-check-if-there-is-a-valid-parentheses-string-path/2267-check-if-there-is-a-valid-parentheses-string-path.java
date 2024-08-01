class Solution {
    int m,n;
    Boolean[][][] dp = new Boolean[100][100][200];
    public boolean dfs(int r,int c,int k,char[][] grid){
        if( r == m || c == n){
            return false;
        }
        if (grid[r][c] == '('){
            k++;
        }
        else{
            k--;
        }
        if( k < 0){
            return false;
        }
        if (r == m - 1 && c == n - 1){
            return k == 0 ? true : false;
        }
        if (dp[r][c][k] != null){
            return dp[r][c][k];
        }
        return dp[r][c][k] = dfs(r+1,c,k,grid) || dfs(r,c+1,k,grid);
        
    }
    public boolean hasValidPath(char[][] grid) {
        m = grid.length ; n = grid[0].length;
        return dfs(0,0,0,grid);
    }
}