class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>();
        Set<String> col = new HashSet<>();
        Set<String> box = new HashSet<>();
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int boxe = (i/3) + (j/3)*3;
                char value = board[i][j];
                if(value!='.') {
                    String r = i+"-"+value;
                    String c = j+"-"+value;
                    String b = boxe+"-"+value;
                    if(row.contains(r) || col.contains(c) || box.contains(b)) {
                        return false;
                    }
                    row.add(r);
                    col.add(c);
                    box.add(b);
               }
            }
        }
        return true;
    }
}

