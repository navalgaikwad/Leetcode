class Solution {
    public void solve(char[][] board) {
       int row = board.length;
       int col = board[0].length;
        
        for(int i=0; i<col; i++){
            if(board[0][i] == 'O'){
              // go deep inside row
              dfs(board, 0, i);
            }
            if(board[row-1][i] == 'O'){ 
             // go deep inside col
             dfs(board, row-1, i);
            }
        }
        
        for(int i=0; i<row; i++){
             if(board[i][0] == 'O'){
              dfs(board, i, 0);
            }
            if(board[i][col - 1] == 'O'){
              dfs(board, i, col - 1);
            }
           
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]=='O'){
                 // dfs(board, i, j);
                  board[i][j] = 'X';
                }
                else if( board[i][j] == '$'){
                   board[i][j] = 'O' ;
                }
            }
        }
        
        
    }
    
    void dfs(char[][] board, int i, int j){
        if(i < 0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == 'X' || board[i][j] == '$'){
            return;
        }
      board[i][j] ='$';
      dfs(board, i+1, j);
      dfs(board, i, j+1);
      dfs(board, i-1, j); 
      dfs(board, i, j-1);

    }
}