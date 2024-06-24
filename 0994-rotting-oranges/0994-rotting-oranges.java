class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j =0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});//row, col, time
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
        int maxTime = 0;
        while(!q.isEmpty()) {
            int[] current  = q.remove();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            maxTime = Math.max(maxTime, time);
            for(int[] dir : dirs) {
                int neighbourRow = row + dir[0];
                int neighbourCol = col + dir[1];
                if(neighbourRow >= 0 && neighbourRow< grid.length && neighbourCol >=0 && neighbourCol < grid[0].length 
                   && grid[neighbourRow][neighbourCol] != 0 && grid[neighbourRow][neighbourCol] != 2 ) {
                    grid[neighbourRow][neighbourCol] = 2;
                    fresh--;
                    q.add(new int[]{neighbourRow, neighbourCol, time + 1});
                }
            }
        }
        
        return fresh > 0 ? -1: maxTime;
    }
}