class Solution {
    public int swimInWater(int[][] grid) {
           int length = grid.length;
       // int low =grid[0][0];
        int s=grid[0][0];
        int e =length*length-1;
        while(s<e){
             boolean visited[][] = new boolean[length][length];
            int mid = s + (e-s)/2;
            if(dfs(grid, 0, 0, mid, visited)){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
    
    boolean dfs(int[][] grid, int i, int j, int no, boolean visited[][]){
        if(i<0 || i>=grid.length || j<0||j>=grid[0].length || grid[i][j]>no || visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        if( i== grid.length-1 && j == grid.length-1){
            return true;
        }
        return dfs(grid, i+1, j, no, visited) || dfs(grid, i, j+1, no, visited) 
            || dfs(grid, i-1, j, no, visited) || dfs(grid, i, j-1, no,visited);
    }
}