class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>();
        for(int i =0; i < board.length; i++) {
            for(int j=0; j< board[0].length; j++) {
                
                 char value = board[i][j];
                 int box = (i/3) + (j/3)*3;
                
                if(value != '.') {
                    String r = value+"r"+i;
                    String c = value+"c"+j;
                    String boxi = value+"b"+box;
                    if(row.contains(r) || row.contains(c) || row.contains(boxi)) {
                        return false;
                    }
                        
                    row.add(c);
                    row.add(r);
                    row.add(boxi);
                    
                }
            }
        }
        return true;
    }
}