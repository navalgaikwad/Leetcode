class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<n; i++) {//col
            if(board[0][i] == 'O') {
              dfs(board, 0, i);  
            }
            if(board[m-1][i] == 'O') {
              dfs(board, m-1, i);  
            }
        }
        for(int i=0; i<m; i++) {//row
            if(board[i][0] == 'O') {
              dfs(board, i, 0);  
            }
            if(board[i][n-1] == 'O') {
              dfs(board, i, n-1);  
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if(board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    void dfs(char[][] board, int i, int j) {
        if(i < 0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='$' || board[i][j]=='X') {
            return;
        }
        board[i][j] = '$';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
        dfs(board, i-1, j);
    }
}
// /
// [["X","$","X","X"],
//  ["X","$","$","X"],
//  ["X","X","$","X"],
//  ["X","$","X","X"]]