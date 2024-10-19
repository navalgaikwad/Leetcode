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
    
    boolean helper(char[][] board, String word, int i, int j, int index) {
        if(word.length() == index) {
            return true;
        }
        if( i < 0 || i >= board.length || j < 0 || j >=board[0].length || board[i][j] == '$' || word.charAt(index)!= board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        boolean left = helper(board, word, i + 1, j, index  +1);
        boolean right = helper(board, word, i, j + 1, index  +1);
        boolean up = helper(board, word, i - 1, j, index  +1);
        boolean down = helper(board, word, i , j - 1, index  +1);
        board[i][j] = temp;
        return left || right || up || down;
    }
}

//O(m∗n∗4L)
//O(L)