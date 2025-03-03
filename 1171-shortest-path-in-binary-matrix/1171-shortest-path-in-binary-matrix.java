class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1; 
        }
        int[][] dirs = {{0,1}, {1,0},{-1,0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1},{-1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        //Boolean[][] visited = new Boolean[grid.length][grid[0].length];
        //visited[0][0] = true;
        HashSet<String> set = new HashSet<>();
        set.add("0-0");
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];
            int count = current[2];
            if(i == grid.length - 1 && j == grid[0].length -1) {
                return count;
            }
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 1 && !set.contains(x+"-"+y)) {
                    grid[x][y] = 1;
                    //visited[x][y] = true;
                    set.add(x+"-"+y);
                    q.add(new int[]{x, y, count + 1});

                }
            }
        }
        return -1;
        
    }
}