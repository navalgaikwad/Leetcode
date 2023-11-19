class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> col = new HashSet<>();
        Set<String> row = new HashSet<>();
        Set<String> boxes = new HashSet<>();
        //we are dealing with value not row and coloumns
        for(int i = 0; i < board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int box = (i/3) + (j/3)*3;
                if(board[i][j] != '.'){
                    char val =  board[i][j];
                    if(col.contains(i +"-"+ val) || row.contains(j +"-"+ val) || boxes.contains(box+"-"+val)) {
                        return false;
                    }
                    col.add(i+"-"+val);
                    row.add(j+"-"+val);
                    boxes.add(box+"-"+val);
                }
            }
        }
        return true;
    }
}