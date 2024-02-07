class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count =0;
        for(int i=0; i<grid2.length; i++) {
            for(int j=0; j<grid2[0].length; j++) {
                boolean[] flag = new boolean[1];
                if(grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j, flag);
                    if(!flag[0]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    void dfs(int[][] grid1, int[][] grid2, int i, int j, boolean[] flag) {
        if(i < 0 || i>=grid2.length || j<0 || j>=grid2[0].length || grid2[i][j] != 1) {
            return;
        }
        if(grid2[i][j] == 1) {
            if(grid1[i][j] == 0) {
                flag[0] = true;
                return;
            }
        }
        grid2[i][j] = 0;
        dfs(grid1, grid2, i+1, j, flag);
        dfs(grid1, grid2, i-1, j, flag);
        dfs(grid1, grid2, i, j+1, flag);
        dfs(grid1, grid2, i, j-1, flag);
    }
}