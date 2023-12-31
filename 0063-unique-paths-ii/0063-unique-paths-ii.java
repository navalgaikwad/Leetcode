class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dp(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, new HashMap<>());
    }
    
    int dp(int[][] grid, int i, int j, HashMap<String, Integer>memo) {
        String key = i+"-"+j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(i < 0 || j < 0 || grid[i][j] == 1) {
            return 0;
        }
        if(i == 0 && j == 0) {
            return 1;
        }
        int result = dp(grid, i - 1, j, memo) + dp(grid, i, j - 1, memo);
        memo.put(key, result);
        return result;
    }
}