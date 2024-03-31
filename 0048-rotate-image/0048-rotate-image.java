class Solution {
    
    /*
    [[1,2,3],
    [4,5,6],
    [7,8,9]]
    
    [7,8,9],
    [4,5,6],
    [[1,2,3]
    
    [7,4,1]
    [8,5,2]
    [9,6,3]
    
[[7,8,1],
[4,5,2],
[9,6,3]]
    
    */
    public void rotate(int[][] matrix) {
        int len = matrix.length-1;
        for(int i=0; i<=len/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[len - i ];
            matrix[len - i ] = temp;
        }
        
        for(int i =0; i<len; i++) {
            for(int j = i+1; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}