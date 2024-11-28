for(int i = 0; i < row; i++){
for(int j =0; j < col; j++){
if(dp[i][j] != 1){
if(i +1 < row){
dp[i+1][j] = dp[i+1][j] +dp[i][j];
}
if(j + 1 < col){
dp[i][j+1] +=dp[i][j];
}
}
}
}
class Solution {
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
int m = obstacleGrid.length;
int n = obstacleGrid[0].length;
int[][] dp = new int[m + 1][n + 1];
dp[0][0] =1;
for(int i =0; i < m; i++) {
for(int j=0; j< n; j++) {
if(obstacleGrid[i][j] == 1) {
dp[i][j] = 0;
} else {
if(i -1  >= 0){
dp[i][j] += dp[i-1][j] ;
}
if(j - 1 >= 0){
dp[i][j] += dp[i][j-1];
}
}
}
}
return dp[m-1][n-1];
}
}