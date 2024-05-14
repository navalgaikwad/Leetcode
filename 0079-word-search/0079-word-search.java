class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) {
            return true;
        }
        if( i < 0 ||  i >=board.length || j < 0 || j >=board[0].length || board[i][j] != word.charAt(index) || board[i][j] == '$') {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        boolean bottom = dfs(board, word, i+1, j, index+1);
        boolean right = dfs(board, word, i, j+1, index+1);
        boolean top = dfs(board, word, i-1, j, index+1);
        boolean left = dfs(board, word, i, j-1, index+1);
        board[i][j] = temp;
        return left || right || top || bottom;
    }
}