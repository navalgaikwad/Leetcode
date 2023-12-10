class Solution {
    public int swimInWater(int[][] grid) {
        int left =grid[0][0];
        int right = grid.length * grid.length - 1;
       
        while(left<=right) {
            boolean visited[][] = new boolean[grid.length][grid.length];
            int mid = left + (right - left)/2;
            if(dfs(grid, 0, 0, mid, visited)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    boolean dfs(int[][] grid, int i, int j, int mid, boolean visited[][]) {
        
        int len = grid.length;
        if(i<0 || i>=len || j<0 || j>=grid[0].length || grid[i][j] > mid|| visited[i][j]) {
            return false;
        }
        if(i == len - 1 && j ==len - 1) {
            return true;
        }
       visited[i][j] = true;
       boolean flag = dfs(grid, i + 1, j, mid, visited) ||
        dfs(grid, i , j + 1, mid, visited)||
        dfs(grid, i - 1, j, mid, visited)||
        dfs(grid, i, j - 1, mid, visited);
        //visited[i][j] = false;
        return flag;
    }
}