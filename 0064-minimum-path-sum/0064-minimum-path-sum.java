class Solution {
    public int minPathSum(int[][] grid) {
        return dp(grid, grid.length - 1, grid[0].length-1, new HashMap<>());
    }
    int dp(int[][] grid, int m, int n, HashMap<String, Integer> memo) {
        String key = m+"-"+n;
        if(memo.containsKey(key)) return memo.get(key); 
        if(m == 0 && n == 0) {
            return grid[m][n];
        }
        if(m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        Integer min = Integer.MAX_VALUE;
        int up = dp(grid, m - 1, n, memo);
        int left = dp(grid, m , n - 1, memo);
        
        min = grid[m][n] + Math.min(left, up);
        memo.put(key, min);
        return min;
    }
}