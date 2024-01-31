class Solution {
    public int orangesRotting(int[][] grid) {
         if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;
        for(int i=0; i <m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if(countFresh == 0) return 0;
        int count =0;
        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty()) {
            ++count;
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                int[] current = q.remove();
                for(int[] d: dir) {
                    int x = current[0] + d[0];
                    int y = current[1] + d[1];
                    
                    if(x >=0 && x<grid.length && y>=0 && y<grid[0].length &&grid[x][y] != 0 && grid[x][y]!=2) {
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                        countFresh--;
                    }
                }
            }
        }
        return countFresh == 0 ? count-1 : -1;
    }
}