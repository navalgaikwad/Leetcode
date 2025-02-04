class Solution {
    public void rotate(int[][] matrix) {
       int n = matrix.length-1;
       for(int i=0; i<=n/2; i++) {
        int[] temp = matrix[i];
        matrix[i] = matrix[n-i];
        matrix[n-i] = temp;
       }
    
    for(int i=0; i<matrix[0].length; i++) {
        for(int j=i+1; j<matrix.length; j++) {
          int temp = matrix[j][i];
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