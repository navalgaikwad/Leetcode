class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Integer[][] dp = new Integer[row][col]; 
        int ans = Integer.MIN_VALUE;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == '1') {
                    int result = helper(matrix, i, j, dp);
                    ans = Math.max(result, ans);
                }
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans*ans; 
    }
    
    int helper(char[][] matrix, int row, int col, Integer[][] memo) {
        if(row < 0 || row >=matrix.length || col < 0 || col>= matrix[0].length || matrix[row][col] == '0') {
            return 0;
        }
        if(memo[row][col]!=null) {
            return memo[row][col];
        }
        int value = 1 + Math.min(helper(matrix, row - 1, col - 1, memo), Math.min(helper(matrix, row - 1, col, memo), helper(matrix, row, col - 1, memo)));
        memo[row][col] = value;
        return value;
    }
}