class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i=0; i<len/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = temp;
        }
        for(int i =0; i<matrix.length; i++) {//i =0
            for(int j =i+1; j<matrix[0].length; j++) {//j =i+1
                int temp =matrix[j][i];
                matrix[j][i] =  matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}

/*
[[1,2,3],
[4,5,6],
[7,8,9]]

[7,8,9]
[4,5,6]
[1,2,3]


[[7,4,1],
[8,5,6],
[9,2,3]]


*/