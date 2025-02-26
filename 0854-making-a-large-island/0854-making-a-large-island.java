class Solution {
    public int largestIsland(int[][] grid) {
        int maxIsland = Integer.MIN_VALUE;
        int color =2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< grid.length; i++) {
            for(int j =0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j, color);
                    maxIsland = Math.max(maxIsland, area);
                    map.put(color, area);
                    color++;
                }
            }
        }
        int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0,-1}};
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> visited = new HashSet<>();
                    int possibleSize =1;
                    for(int[] dir : dirs) {
                         int x = i + dir[0];
                         int y = j + dir[1];
                        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] > 1) {
                            int id = grid[x][y];
                            if(!visited.contains(id)) {
                                visited.add(id);
                                possibleSize+=map.get(id);
                            }
                        }

                    }
                     maxIsland = Math.max(maxIsland, possibleSize);
                }
            }
        }
        return maxIsland;
    }

    int dfs(int[][] grid, int i, int j, int color) {
	if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length || grid[i][j] != 1) {
		return 0;
	}
	grid[i][j]= color;
	int left = dfs(grid, i -1, j, color);
	int right = dfs(grid, i, j -1, color);
	int top = dfs(grid, i + 1, j, color);
	int bottom = dfs(grid, i, j+1, color);
	return 1 + left + right + top + bottom;
}																							

}