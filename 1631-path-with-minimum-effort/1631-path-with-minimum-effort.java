class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)->a[2] - b[2]);
        min.add(new int[]{0,0,0});
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        int[][] dirs= {{0,1}, {1,0}, {0,-1}, {-1, 0}};
        while(!min.isEmpty()) {
            int[] current = min.remove();
            int x = current[0];
            int y = current[1];
            int level = current[2];
           
            if(x == row - 1 && y == col - 1) {
                return level;
            }
            for(int[] dir : dirs) {
                int i = dir[0] + x;
                int j = dir[1] + y;
                if(i>=0 && i<row && j>=0 && j<col) {
                    int effort = Math.max(level, Math.abs(heights[i][j]-heights[x][y]));
                    if(effort < dist[i][j]) {
                        dist[i][j] = effort;
                        min.add(new int[]{i, j, effort});
                    }
                    
                }
            }
        }
        return -1;
    }
}

