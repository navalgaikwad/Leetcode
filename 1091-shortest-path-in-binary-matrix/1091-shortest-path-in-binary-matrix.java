class Solution {
    
    public boolean isValid(int[][] grid, int i, int j){
        return (i>=0) && (i < grid.length) && (j >=0) && (j<grid[0].length) && (grid[i][j] != 1);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if (grid[0][0] == 1) {
            return -1; 
        }
        
        Set<String> visited = new HashSet<>();
        int[][] directions = {{1,0}, {0, 1}, {-1,0}, {0, -1}, {1, 1},{-1, 1},{1,-1}, {-1, -1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited.add(0 + "-" + 0);//only for grid
        
        while(!queue.isEmpty()){
            int size = queue.size();
         
              
            int[] current = queue.remove();
            int row = current[0];
            int col = current[1];
            int length = current[2];
            if(row == m - 1 && col == n - 1){
                return length;
            }
            for(int[] direction: directions){
                int rx = direction[0] + row;
                int ry = direction[1] + col;
                if(isValid(grid, rx, ry) && !visited.contains(rx+"-"+ry)){
                     queue.offer(new int[]{rx, ry, length + 1});
                     visited.add(rx + "-" + ry);//only for grid
                }
            
          }       
        }
        return -1;
    }
}