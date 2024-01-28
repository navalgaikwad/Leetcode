class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rowSet = new HashSet<>();
        Set<String> colSet = new HashSet<>();
        Set<String> boxesset = new HashSet<>();
        int row = board.length;
        int col = board[0].length;
       
            for(int i=0; i< row; i++) {
                for(int j=0; j<col; j++) {
                    char value = board[i][j];
                    int box = (i/3) + (j/3) *3;
                    if(value != '.') {
                        
                        String r = i+"-"+value;
                        String c = j+"-"+value;
                        String b = box+"-"+value;
                        if(rowSet.contains(r) || colSet.contains(c) || boxesset.contains(b)) {
                            return false;
                        }
                        rowSet.add(r);
                        colSet.add(c);
                        boxesset.add(b);
                    }
                }
            }
            
        return true;
        }
    }
