class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m =  matrix.length;
        int n =  matrix[0].length;
        boolean[][] visited= new boolean[m][n];
        int max=0;
        int[][] dp =new int[m][n];
        for(int i=0; i<m; i++){
           for(int j=0; j<matrix[i].length; j++){
               dfs(matrix, i, j, visited, matrix[i][j]-1, dp);
               max=Math.max(max, dp[i][j]);
           } 
        }
        return max;
    }
    
    int dfs(int[][] matrix, int i, int j, boolean[][] visited, int prev, int[][] dp){
        if(i <0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]<=prev){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        //visited[i][j]=true;
        int top = dfs(matrix, i+1, j, visited, matrix[i][j], dp);
        int bottom = dfs(matrix, i-1, j, visited, matrix[i][j], dp);
        int left = dfs(matrix, i, j-1, visited, matrix[i][j], dp);
        int right = dfs(matrix, i, j+1, visited, matrix[i][j], dp);
        dp[i][j]=1+Math.max(Math.max(top,  bottom), Math.max(left, right));
        return dp[i][j];
    }
}