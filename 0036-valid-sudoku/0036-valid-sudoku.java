class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set  =new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int value = board[i][j];
                int box = (i/3) + (j/3) * 3;
                if(value!='.') {
                    String row= value+"r"+i;
                    String col = value+"c"+j;
                    String boxes = value+"b"+box;
                    if(set.contains(row) || set.contains(col) || set.contains(boxes)) {
                        return false;
                    }
                    set.add(row);
                    set.add(col);
                    set.add(boxes);
                }
            }
        }
        return true;
    }
}