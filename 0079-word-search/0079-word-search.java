class Solution {
    public boolean exist(char[][] board, String word) {
         boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i =0; i<board.length; i++) {
            for(int j =0; j<board[0].length; j++) {
               
                if(board[i][j]==word.charAt(0)) {
                    
                    if(dfs(board, word, i, j, 0) ){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] board, String word, int i, int j, int index) {
        if(index >= word.length()) {
            return true;
        }
        if(i >=board.length || i< 0 || j >= board[0].length || j<0 
           || word.charAt(index)!= board[i][j] || board[i][j]=='$') {
            return false;
        }
        
        char c = board[i][j];
        //visited[i][j] = true;
        board[i][j] ='$';
        boolean flag = dfs(board, word, i+1, j, index+1) || 
                       dfs(board, word, i-1, j, index+1) || 
                       dfs(board, word, i, j-1, index+1) || 
                       dfs(board, word, i, j+1, index+1);
        board[i][j] = c;
        return flag;
    }
}