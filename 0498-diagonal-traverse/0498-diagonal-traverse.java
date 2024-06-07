class Solution {
    public int[] findDiagonalOrder(int[][] mat) {  
        int m = mat.length, n = mat[0].length;
        boolean up = true;
        int row = 0, col = 0;
        int i = 0;
        int[] arr = new int[m * n];
        while( row < m && col < n  ) {
            if(up) {
                while(row > 0 && col < n-1) {
                    arr[i++] = mat[row][col];
                    row--;
                    col++;
                }
                arr[i++] = mat[row][col];
                if(col == n- 1) {
                    row++;
                }else {
                    col++;
                }
            }else {
                while(col > 0 && row < m-1) {
                    arr[i++] = mat[row][col];
                    col--;
                    row++;
                }
                arr[i++] = mat[row][col];
                if(row == m- 1) {
                    col++;
                }else {
                    row++;
                }
            }
             up = !up;
        }
        return arr;
    }
}