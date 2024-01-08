class Solution {
    int size;
    public int totalNQueens(int n) {
        this.size = n;
        return backTracking(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
    
    int backTracking(int row, HashSet<Integer> diagonalSet, HashSet<Integer> antiDiagonal, HashSet<Integer> cols) { 
        if(row == size) {
            return 1;
        }
        
        int solution =0;
        for(int col=0; col < size; col++) {
            int diagonal = row - col; // top right to bottom left
            int antiDiag = row + col; // top left to bottom right
            if(diagonalSet.contains(diagonal) || antiDiagonal.contains(antiDiag) || cols.contains(col)) {
                continue;
            }
            
            cols.add(col);
            antiDiagonal.add(antiDiag);
            diagonalSet.add(diagonal);
            solution+=backTracking(row+1, diagonalSet, antiDiagonal, cols);

            cols.remove(col);
            antiDiagonal.remove(antiDiag);
            diagonalSet.remove(diagonal);
        }
         return solution;
    }
}
