class Solution {
      public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Iterate through the matrix and mark the first element of each row and column
        // where a zero is encountered.
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Iterate through the matrix in reverse and update the elements based on the
        // marked first elements of rows and columns.
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}