class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>();
        Set<String>col = new HashSet<>();
        Set<String>boxes = new HashSet<>();
        for(int i =0; i < board.length; i++) {
            for(int j=0; j< board[0].length; j++) {
                
                 char value = board[i][j];
                 int box = (i/3) + (j/3)*3;
                
                if(board[i][j] != '.') {
                    String c = value+"-"+i;
                    String v = value+"-"+j;
                    String boxi = value+"-"+box;
                    if(row.contains(c) || col.contains(v) || boxes.contains(boxi)) {
                        return false;
                    }
                        
                    row.add(c);
                    col.add(v);
                    boxes.add(boxi);
                }
            }
        }
        return true;
    }
}