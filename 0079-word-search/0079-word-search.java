class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean helper(char[][] board, String word, int index, int i, int j) {
        if(word.length() == index) {
            return true;
        }
        if(i <0 || i>= board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(index) || board[i][j]=='$') {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '$';
        boolean up = helper(board, word, index+1, i+1, j);
        boolean left = helper(board, word, index+1, i-1, j);
        boolean right = helper(board, word, index+1, i, j+1);
        boolean down = helper(board, word, index+1, i, j-1);
        board[i][j] = c;
        
        return up||left||right||down;
    }
}