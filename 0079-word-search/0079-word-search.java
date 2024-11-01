class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean helper(char[][] board, String word, int row, int col, int index) {
         if(index == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col]!= word.charAt(index)) {
            return false;
        }
        
       
        
        char c =  board[row][col];
        board[row][col] = '$';
        boolean left = helper(board, word, row+1, col, index+1);
        boolean right = helper(board, word, row, col+1, index+1);
        boolean up = helper(board, word, row-1, col, index+1);
        boolean bottom = helper(board, word, row, col-1, index+1);
        board[row][col]= c;
        return left || right || up || bottom;
    }
}