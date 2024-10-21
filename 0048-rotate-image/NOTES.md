for (int j = i + 1; j < matrix[i].length; j++) {
int temp = matrix[i][j];
matrix[i][j] = matrix[j][i];
matrix[j][i] = temp;
}
}
}
}
​
class Solution {
public void rotate(int[][] matrix) {
int len = matrix.length;
for(int i=0; i<len/2; i++) {
int[] tmp = matrix[i];
matrix[i] = matrix[len - i - 1];
matrix[len - i - 1]= tmp;
}
for(int i=0; i<matrix.length; i++) {
for(int j = i + 1; j<matrix[0].length; j++) {
int tmp = matrix[j][i];
matrix[j][i] = matrix[i][j];
matrix[i][j] = tmp;
}
}
}
}
//matrix = [[1,2,3],[4,5,6],[7,8,9]]
​
/*
[[1,2,3],
[4,5,6],
[7,8,9]]
​
khalach warti ghe
mg 0 ani 1 pasun start kar
​
​
*/