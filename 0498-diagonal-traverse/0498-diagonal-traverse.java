class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = 0, col = 0;
        int m = mat.length;
        int n = mat[0].length;
        int index =0;
        int[] result = new int[m*n];
        boolean up = true;
        while(row < m && col < n) {
            if(up) {
               while(row > 0 && col < n - 1) {
                   result[index++] = mat[row][col];
                   row--;
                   col++;
               }
                result[index++] = mat[row][col];
                if(col == n-1) {
                    row++;
                }else {
                    col++;
                }
                
            }else {
                 while(col > 0 && row < m - 1) {
                   result[index++] = mat[row][col];
                   row++;
                   col--;
               }
                result[index++] = mat[row][col];
                if(row == m-1) {
                    col++;
                }else {
                    row++;
                }
            }
            up = !up;
        }
        return result;
    }
}