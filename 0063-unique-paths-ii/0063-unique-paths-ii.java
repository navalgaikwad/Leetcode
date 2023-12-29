class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int result = dfs(obstacleGrid, obstacleGrid.length -1, obstacleGrid[0].length-1, new HashMap<>());
       return result; 
    }
    
    int dfs(int[][] grid, int i, int j, Map<String, Integer> memo) {
        String key = i+"-"+j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(i == 0 && j == 0 && grid[i][j]==0) {
            return 1;
        }
        if( i< 0 || j < 0 || grid[i][j]==1) {
            return 0;
        }
        int result = dfs(grid, i - 1, j, memo) + dfs(grid, i, j - 1, memo);
        memo.put(key, result);
        return result;
    }
    
}