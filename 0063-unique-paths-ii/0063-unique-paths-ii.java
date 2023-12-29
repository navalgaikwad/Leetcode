class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int result = dfs(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, new HashMap<>());
       return result; 
    }
    
    int dfs(int[][] grid, int i, int j, Map<String, Integer> memo) {
        String key = i+"-"+j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(i == 0 && j == 0 && grid[i][j] == 0) {//last no obstacle when  i == 0 && j == 0 && grid[i][j] == 0 then return 1;
            return 1;
        }
        if( i< 0 || j < 0 || grid[i][j] == 1) { // if anywhere you find the i<0 or j <0 or grid[i][j] == 1 return 0
            return 0;
        }
        int result = dfs(grid, i - 1, j, memo) + dfs(grid, i, j - 1, memo);//this is main we need to go down i -1 and j -1 which will evetaully give the answer
        memo.put(key, result);
        return result;
    }
    
}