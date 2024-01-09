class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0; i<col; i++) {
            dfs(board, 0, i);
            dfs(board, row -1, i);
        }
        
        for(int i =0; i<row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j]=='O') {
                   board[i][j] ='X'; 
                }else if(board[i][j]=='$') {
                   board[i][j] ='O'; 
                }
            }
        }
    }
    
    void dfs(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        if(i >= row || i<0 || j>=col || j<0 || board[i][j]=='X' || board[i][j]=='$') {
            return;
        }
        board[i][j]='$';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }
}