class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length - 1;
        int col = obstacleGrid[0].length -1;
        return helper(obstacleGrid, row, col, new HashMap<>());
    }
    int helper(int[][] obstacleGrid, int i, int j, HashMap<String, Integer> memo){
        String key = i+"-"+j;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if( i < 0 || j < 0 || obstacleGrid[i][j] == 1 ){
            return 0;
        }
        
        if( i == 0 && j == 0){
            return 1;
        }
        int val1 = helper(obstacleGrid, i-1, j, memo);
        int val2 = helper(obstacleGrid, i, j-1, memo);
        
        memo.put(key, val1+val2);
       // System.out.println(memo);
        return memo.get(key);
    }
}