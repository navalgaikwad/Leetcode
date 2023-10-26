class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length - 1;
        int col = grid[0].length -1;
        return helper(grid, row, col, new HashMap<>() );
    }
    
    int helper(int[][] grid, int i, int j, HashMap<String, Integer> memo){
        String key = i+"-"+j;
        if(memo.containsKey(key)){
           return memo.get(key); 
        }
         if( i < 0 || j < 0 ){
            return Integer.MAX_VALUE;
        }
        if( i == 0 && j == 0){
            return grid[i][j];
        }
       int val1 =  helper(grid, i - 1, j, memo);
       int val2 =  helper(grid, i, j - 1, memo);
        
        int result = Math.min(val1, val2)+ grid[i][j];
        memo.put(key, result);
        return result;
    }
}