class Solution {
    public int minPathSum(int[][] grid) {
        return dp(grid, grid.length - 1, grid[0].length - 1, new HashMap<>());
    }
    
    int dp(int[][] grid, int i, int j, HashMap<String, Integer> memo) {
        String key = i+"-"+j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if( i==0 && j == 0) {
            return grid[i][j];
        }
        if(i < 0 || j <0) {
            return Integer.MAX_VALUE;
        }
        int down = dp(grid, i-1, j, memo);
        int up = dp(grid, i, j-1, memo);
        
        int result = grid[i][j] + Math.min(down, up);
        memo.put(key, result);
        return result;
    }
}