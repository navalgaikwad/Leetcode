class Solution {
// important learning here
//to check for Math.abs(heights[i][j] - heights[i + 1][j]) diff not more than mid
//best one
int m ;
int n;
public int minimumEffortPath(int[][] heights) {
m = heights.length;
n = heights[0].length;
int left = 0;
int right = 0;
//find the max value in the
for (int[] row: heights) {
for (int num: row) {
right = Math.max(right, num);
}
}
while (left <= right) {
int mid = left + (right - left) / 2;
if (dfs(heights, 0, 0, mid, new boolean[m][n])) {
right = mid - 1;
} else {
left = mid + 1;
}
}
return left;
}
int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};
boolean isValid (int i, int j, boolean[][] visited) {
return i>=0 && j>=0 && i<m && j <n && !visited[i][j];
}
//run the dfs
boolean dfs(int[][] heights, int i, int j, int mid, boolean[][] visited) {
if( i == m -1 && j == n - 1) {//check for end condition
return true;
}
visited[i][j] = true;//mark it true visited
for(int[] dir : directions){
int x = i + dir[0], y = j + dir[1];// take directions
//verify the direction out of bound
if( isValid(x, y, visited) && Math.abs(heights[i][j] - heights[x][y]) <= mid ){//check edge condition
if(dfs(heights, x, y, mid, visited)) {//
return true;
}
}
}
return false;
}
}