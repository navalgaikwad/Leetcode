class Solution {
    boolean isValid(int[][] grid, int i, int j, int k){
        return i >=0 & i<grid.length && j >=0 && j<grid[0].length && k>=0;
    }
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, k, 0});
        Set<String> visited = new HashSet<>();
        
        visited.add(0+"-"+0+"-"+k);
        
        while(!queue.isEmpty()){
            
          int[] current = queue.remove();
          int row = current[0];
          int col = current[1];
          k = current[2];
          int level = current[3];
          
          if(row == m-1 && col == n-1){
              return level;
          }
            
          for(int[] direction: directions){
              int rx = direction[0] + row;
              int ry = direction[1] + col;
              
              if(isValid(grid, rx, ry, k) && !visited.contains(rx+"-"+ry+"-"+k)){
                  int val = k - grid[rx][ry];
                  queue.add(new int[]{rx, ry,  val, level + 1});
                  visited.add(rx+"-"+ry+"-"+k);
              }
          }
            
        }
        return -1;
    }
}