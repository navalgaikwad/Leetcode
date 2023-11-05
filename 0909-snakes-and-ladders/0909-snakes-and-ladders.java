class Solution {
    public int snakesAndLadders(int[][] board) {
      int n = board.length;
      int target = n*n;
      Integer[] columns = new Integer[n];
      for(int i=0; i<n; i++){
          columns[i] = i;
      }
        
      int label = 1;
      Pair<Integer, Integer> cell[] = new Pair[n*n+1];
      for(int row = n - 1; row >=0; row--){
          for(int col : columns){
             //System.out.print(label+" label, "+row +" row, "+col+" col ");
            cell[label++] = new Pair<>(row, col);  
          }
           Collections.reverse(Arrays.asList(columns));
      }
        
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        
        while( !q.isEmpty() ){
            int[] current = q.remove();
            int currentStep = current[0];
            int level = current[1];
            
            if(currentStep == target){
                return level;
            }
    
            
            for(int i =1; i < 7; i++){
                
              int nextLabel = currentStep + i;
                  if(nextLabel <= target){

                      int row = cell[nextLabel].getKey();
                      int col = cell[nextLabel].getValue();

                      int destination = (board[row][col]!=-1) ? board[row][col]: nextLabel;

                     if(!visited.contains(destination)){
                         visited.add(destination);
                         q.add(new int[]{destination, level + 1});
                     } 
                }     
            }
       }
     return -1;
    }
}