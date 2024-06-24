class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        //Integer[][] memo = new Integer[grid.length][grid.length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    max = Math.max(max, helper(grid, i, j)); 
                }
            }
        }
        return max;
    }
    
    int helper(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j>=grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int value = grid[i][j];
        grid[i][j] = 0;

        int top = helper(grid, i - 1, j);
        int right = helper(grid, i, j + 1);
        int bottom = helper(grid, i + 1, j);
        int left = helper(grid, i, j - 1);
        
        grid[i][j] = value;
        int max = grid[i][j] + Math.max(top, Math.max(left, Math.max(right, bottom)));
        return max;
    }
}