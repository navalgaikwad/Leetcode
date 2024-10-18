class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j =0; j<board[0].length; j++) {
                char value = board[i][j];
                int box = (i/3) + (j/3) *3;
                if(value != '.') {
                    String row = i+"row"+value;
                    String col = j+"col"+value;
                    String boxValue = box+"box"+value;
                    if(set.contains(row) || set.contains(col) || set.contains(boxValue) ) {
                        return false;
                    }
                    set.add(row);
                    set.add(col);
                    set.add(boxValue);
                }
            }
        }
        return true;
    }
}