class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j =0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, String word, int row, int col, int wordIndex) {
         if(wordIndex == word.length()) {
            return true;
        }
        
        if( row >= board.length   || row < 0 || col >= board[0].length || col< 0 || board[row][col] != word.charAt(wordIndex) ||
          board[row][col] == '$') {
            return false;
        }
       
        char temp = board[row][col];
        board[row][col] = '$';
        boolean left = dfs(board, word, row + 1, col, wordIndex + 1);
        boolean rigth = dfs(board, word, row, col + 1, wordIndex + 1);
        boolean up = dfs(board, word, row - 1, col, wordIndex + 1);
        boolean down = dfs(board, word, row, col - 1, wordIndex + 1);
        board[row][col] = temp;
        return left || rigth || up || down;
    }
}