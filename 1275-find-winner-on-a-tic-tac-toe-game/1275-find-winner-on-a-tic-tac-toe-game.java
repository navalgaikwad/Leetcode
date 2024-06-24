class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rowArray = new int[n];
        int[] colArray = new int[n];
        
        int diagonal = 0;
        int diagonalCross = 0;
        int player = 1;
        for(int[] move : moves) {
            int row = move[0];
            int col = move[1];
            
            rowArray[row]+= player;
            colArray[col]+=player;
            
            if(row == col) {
                diagonal+=player;
            }
            if(row + col == n - 1) {
                diagonalCross+=player;
            }
            
            if(Math.abs(rowArray[row] )== n || Math.abs(colArray[col]) == n || Math.abs(diagonal) == n || Math.abs(diagonalCross) == n) {
                if(player == 1) {
                    return "A";
                }else {
                    return "B";
                }
            }
            player= player*-1;
        }
        
        if(moves.length == n*n) {
            return "Draw";
        }else {
            return "Pending";
        }
    }
}