class Solution {
    public int minPathSum(int[][] grid) {
        return helper(grid.length-1, grid[0].length-1, grid, new HashMap<>());
    }
    
    int helper(int i, int j, int[][] grid, HashMap<String, Integer> memo) {
        String key = i+"-"+j;
        if( i== 0 && j ==0) {
            return grid[i][j];
        }
        if(i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int one = helper(i-1, j, grid, memo);
        int two = helper(i, j-1, grid, memo);
        
        int total  = grid[i][j] + Math.min(one, two);
        memo.put(key, total);
        return total;
    }
}