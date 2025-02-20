class Solution {
    public void setZeroes(int[][] matrix) {
        
        int row = 0;
        int col =0;
        int[][] arr = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
               arr[i][j] = matrix[i][j];
            }
        }
         for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(arr[i][j] == 0) {
                    for(int a=0; a< matrix[0].length; a++) {
                        matrix[i][a] = 0;
                    }
                    for (int b = 0; b < matrix.length; b++) {
                        matrix[b][j] = 0;
                    }
                }

        }
      }
    }
}