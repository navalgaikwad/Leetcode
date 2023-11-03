class Solution {
    public int countBattleships(char[][] board) {
     int count =0;
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='X'){
              if(i==0 && j==0){
                  count++;
                  
              }else if(i == 0){
                 if(board[i][j - 1]!='X'){
                     count++; 
                 } 
              } else if(j == 0){
                 if(board[i - 1][j]!='X'){
                     count++; 
                 } 
              }else if(board[i - 1][j]!='X' && board[i][j - 1]!='X'){
                  count++; 
          }  
        }
      }
    }
    return count;
  }
}