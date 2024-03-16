class Solution {
public int longestIncreasingPath(int[][] matrix) {
int row = matrix.length;
int col =matrix[0].length;
int max =0;
HashMap<String, Integer> memo = new HashMap<>();
for(int i=0; i<row; i++) {
for(int j=0; j<col; j++) {
int sum = dfs(matrix, i, j, memo, matrix[i][j]-1);
max=Math.max(max, sum);
}
}
return max;
}
int dfs(int[][] matrix, int i, int j, HashMap<String, Integer> memo, int num) {
int row = matrix.length;
int col = matrix[0].length;
String key = i+"-"+j;
if( i>=row || i<0 || j>=col || j<0 || matrix[i][j] <= num) {
return 0;
}
if(memo.containsKey(key)) {
return memo.get(key);
}
int top = dfs(matrix, i+1, j, memo, matrix[i][j]);
int down =dfs(matrix, i-1, j, memo, matrix[i][j]);
int right =dfs(matrix, i, j-1, memo, matrix[i][j]);
int left =dfs(matrix, i, j+1, memo, matrix[i][j]);
int sum = 1+Math.max(top, Math.max(down, Math.max(right, left))); //whenever there is path use this forrmula
memo.put(key, sum);
return sum;
}
}