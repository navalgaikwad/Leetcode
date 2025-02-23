class Solution {
    public int longestIncreasingPath(int[][] matrix) {
           int row = matrix.length;
        int col =matrix[0].length;
          int max =0;
        Integer[][] memo = new Integer[matrix.length][matrix[0].length];
        //HashMap<String, Integer> memo = new HashMap<>();
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
               int sum = dfs(matrix, i, j, memo, matrix[i][j]-1);
                max=Math.max(max, sum);
            }
        }
        return max;
    }
    
    int dfs(int[][] matrix, int i, int j, Integer[][] memo, int prev) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || prev >= matrix[i][j]) {
            return 0;
        }
        if(memo[i][j]!=null) return memo[i][j];
        int left = dfs(matrix, i + 1, j, memo, matrix[i][j]);
        int right = dfs(matrix, i, j + 1, memo, matrix[i][j]);
        int top = dfs(matrix, i - 1, j, memo, matrix[i][j]);
        int bottom = dfs(matrix, i, j - 1, memo, matrix[i][j]);
        
        int value = 1 + Math.max(left, Math.max(right, Math.max(top, bottom)));
        memo[i][j] = value;
        return value;
    }
}