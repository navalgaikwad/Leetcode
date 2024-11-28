class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dp(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length-1, new HashMap<>());
    }
    
    int dp(int[][] grid, int m, int n, HashMap<String, Integer> memo) {
        String key = m+"-"+n;
        if(m == 0 && n == 0 && grid[m][n] == 0) {
            return 1;
        }
        if(m < 0 || n < 0 || grid[m][n] == 1) {
            return 0;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int right = dp(grid, m - 1, n, memo);
        int down = dp(grid, m, n - 1, memo);
        int answer = right + down;
        memo.put(key, answer);
        return  answer;
    }
}