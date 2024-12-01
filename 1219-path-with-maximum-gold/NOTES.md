class Solution {
//
public int getMaximumGold(int[][] grid) {
int row = grid.length;
int col = grid[0].length;
int max = 0;
for(int i=0; i<row; i++) {
for(int j=0; j<col; j++) {
if(grid[i][j] != 0) {
max = Math.max(max, dfs(grid, i, j));
}
}
}
return max;
}
int dfs(int[][] grid, int i, int j) {
if(i < 0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) {
return 0;
}
int current = grid[i][j];
grid[i][j] = 0; // Mark the current cell as visited
int top = dfs(grid, i+1, j);
int right = dfs(grid, i, j+1);
int left = dfs(grid, i, j-1);
int down = dfs(grid, i-1, j);
grid[i][j] = current;
int sum = grid[i][j] + Math.max(top, Math.max(right, Math.max(left, down)));
return sum;
}
}