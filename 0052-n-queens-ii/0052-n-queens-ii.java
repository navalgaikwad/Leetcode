class Solution {
    int size;
    public int totalNQueens(int n) {
        size = n;
       
        return  backTrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
    
    int backTrack(int row, HashSet<Integer> diagonalSet, HashSet<Integer> antiDiagonalSet, HashSet<Integer> cols){
        if(row == size){
            return 1;
        }
        int solution = 0;
        for(int col =0; col < size; col++){
            int diagonal = row - col; // top right to bottom left
            int antiDiagonal = row + col;// top left to bottom right
            
            //check in the set if it avaiable 
            if(cols.contains(col) || diagonalSet.contains(diagonal) || antiDiagonalSet.contains(antiDiagonal)){
                continue;
            }
            
            //if not add in the cols, diagonalSet, antiDiagonalSet
            cols.add(col);
            diagonalSet.add(diagonal);
            antiDiagonalSet.add(antiDiagonal);
            solution += backTrack(row + 1, diagonalSet, antiDiagonalSet, cols);
            
            //onces everything is done remove evryting
            cols.remove(col);
            diagonalSet.remove(diagonal);
            antiDiagonalSet.remove(antiDiagonal);
            
        }
        return solution;
    }
}