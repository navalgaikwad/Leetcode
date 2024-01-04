class Solution {
    public int minPathSum(int[][] grid) {
        return dp(grid.length - 1, grid[0].length - 1, grid, new HashMap<>());
    }
    int dp(int i, int j, int[][] grid, HashMap<String, Integer> memo) {
        String key = i+"-"+j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(i<0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if(i == 0 && j ==0) {
            return grid[i][j];
        }
        int down = dp(i - 1, j, grid, memo);
        int right = dp(i, j-1, grid, memo);
        int min = grid[i][j] + Math.min(down, right);
        memo.put(key, min);
        return min;
    }
}