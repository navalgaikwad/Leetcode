class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.')
                    continue;
                if(i > 0 && board[i-1][j] == 'X')
                    continue;
                if(j > 0 && board[i][j-1] == 'X')
                    continue;
                res++;
            }
        }
        return res;
    }
}
//check not equal to X
//1st row i =0 j-1
//1st col j =0 i-1
//then i-1 and j-1