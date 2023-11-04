class Solution {
    public boolean isValid(int[][] mat, int i, int j){
        return i >= 0 && i <mat.length && j >=0 &&  j < mat[0].length;
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for( int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 0){
                  queue.add(new int[]{i, j, 0});
                  visited.add(i+"-"+j);
                }
            }
        }
       helper(queue, visited, mat);
       return mat; 
    }
    
    void helper(Queue<int[]> queue,  Set<String> visited, int[][] mat ){
        int[][] directions = {{0,1},{1,0}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int row = current[0];
            int col = current[1];
            int length = current[2];
            if(mat[row][col] != 0){
              mat[row][col] = length;  
            }
            for(int[] direction: directions){
                int rx = direction[0] + row;
                int cy = direction[1] + col;
                
                if(isValid(mat, rx, cy) && !visited.contains(rx+"-"+cy)){
                   queue.add(new int[]{rx, cy, length + 1 }); 
                     visited.add(rx+"-"+cy);
                }
            }
        }
    }
}