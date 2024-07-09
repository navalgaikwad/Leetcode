class Solution {
public List<List<Integer>> pacificAtlantic(int[][] heights) {
List<List<Integer>> result = new ArrayList();
if(heights.length == 0 || heights[0].length == 0)
return result;
​
int rows = heights.length;
int cols = heights[0].length;
boolean [][]pac = new boolean[rows][cols];
boolean [][]atl = new boolean[rows][cols];
​
//traverse top and bottom of island
for(int col=0; col<cols; col++) {
dfs(0, col, pac, heights[0][col], heights);     //0,col               //top row surrounds pacific ocean; 4: prevHeight=start height
dfs(rows-1, col, atl, heights[rows-1][col], heights);//bottom, col          //bottom row surrounds atlantic ocean
}
​
//traverse left and right of island
for(int row=0; row<rows; row++) {
dfs(row, 0, pac, heights[row][0], heights);//row,0              //left=pacific
dfs(row, cols-1, atl, heights[row][cols-1], heights);//row, col - 1,     //right=atlantic
}
​
//find common of pac and atl