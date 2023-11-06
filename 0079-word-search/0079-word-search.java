class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(word.charAt(0)==board[i][j] &&dfs(board, word, i, j, 0) ){
                    return true;
                }
            }
            
        }
        return false;
    }
    // index of word
    // word in char not match return false;
    //if i > word.length return true;
    
    boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i >=board.length || i<0 || j<0 || j>=board[0].length ||
           board[i][j] != word.charAt(index) || board[i][j] == '1'){
            return false;
        }
        
        char temp =  board[i][j];
        board[i][j] = '1';
        boolean flag = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1)|| dfs(board, word, i, j + 1, index + 1) 
                      || dfs(board, word, i , j - 1, index + 1);
        board[i][j] = temp;
        return flag;
    }
}