class Solution {
        public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < 0){
                   count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }
}