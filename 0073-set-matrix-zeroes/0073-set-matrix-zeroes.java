class Solution {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] arr = new int[row][column];

        // copy arr
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = matrix[i][j];
            }
        }

        // start

        for (int a = 0; a < row; a++) {
            for (int b = 0; b < column; b++) {
                if (arr[a][b] == 0) {
                    for (int i = 0; i < column; i++) {
                        matrix[a][i] = 0;
                    }
                    for (int i = 0; i < row; i++) {
                        matrix[i][b] = 0;
                    }

                }
            }
        }

    }
}