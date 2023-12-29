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