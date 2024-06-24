class Solution {
public int orangesRotting(int[][] grid) {
Queue<int[]> q = new LinkedList<>();
int fresh  = 0;
for(int i=0; i<grid.length; i++) {
for(int j=0; j<grid[0].length; j++) {
if(grid[i][j] == 2) {
q.add(new int[]{i, j, 0});
}else if(grid[i][j] == 1){
fresh++;
}
}
}
int max = 0;
int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
while(!q.isEmpty()) {
int[] current = q.remove();
int i = current[0];
int j = current[1];
int count = current[2];
max = Math.max(max, count);
for(int[] dir:dirs) {
int x = i + dir[0];
int y = j + dir[1];
if(x >= 0 && x<grid.length && y>=0 && y < grid[0].length && grid[x][y] != 0 && grid[x][y] != 2) {
q.add(new int[]{x, y, count + 1});
grid[x][y] = 2;//making rotten
fresh--;
}
}
}
return fresh==0 ? max : -1;
}
}