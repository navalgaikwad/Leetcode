class Solution {
    
    private static boolean isValid(char[][] grid, int row, int col) {
    return (row >= 0) && (row < grid.length) && (col >=0 ) && (col < grid[0].length) && (grid[row][col] == '1');
    }

    public int numIslands(char[][] grid) {
       Set<String> visited = new HashSet<>();
       int count = 0;
       for(int i=0; i<grid.length; i++){
           for(int j=0; j<grid[0].length; j++){
               if(grid[i][j]=='1' && !visited.contains(i+"-"+j)){
                    visited.add(i + "-" + j);
                   helper(grid, i, j, visited);
                   count++;
               }
           }
       }
        return count;
    }
    
    void helper(char[][] grid, int row, int col, Set<String> visited ){
         int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
       
        queue.add(new int[]{row, col});
        while(!queue.isEmpty()){
            int n = queue.size();
          
           // for(int i = 0; i < n; i++){
                int[] current = queue.remove();  
               // visited.add(nextRow + "-" + nextCol); adjacency list
                for(int[] dir: directions){
                    int nextRow = current[0] + dir[0];
                    int nextCol = current[1] + dir[1];
                    if(isValid(grid, nextRow, nextCol) && !visited.contains(nextRow + "-" + nextCol)){
                         queue.offer(new int[]{nextRow, nextCol});
                         visited.add(nextRow + "-" + nextCol);//only for grid
                    }
                }
            //}
            
        }
        
    }
}