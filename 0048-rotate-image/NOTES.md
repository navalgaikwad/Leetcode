class Solution {
/*
* clockwise rotate
* first reverse up to down, then swap the symmetry
* 1 2 3     7 8 9     7 4 1
* 4 5 6  => 4 5 6  => 8 5 2
* 7 8 9     1 2 3     9 6 3
*/
public void rotate(int[][] matrix) {
// Reverse the matrix
for (int i = 0; i < matrix.length / 2; i++) {
int[] temp = matrix[i];
matrix[i] = matrix[matrix.length - i - 1];
matrix[matrix.length - i - 1] = temp;
}
​
// Transpose the matrix
for (int i = 0; i < matrix.length; i++) {
for (int j = i + 1; j < matrix[i].length; j++) {
int temp = matrix[i][j];
matrix[i][j] = matrix[j][i];
matrix[j][i] = temp;
}
}
}
}