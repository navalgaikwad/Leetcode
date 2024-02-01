class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}, {-1,-1}, {1, 1}, {-1, 1}, {1, -1}};
         if (grid[0][0] == 1) {
            return -1; 
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        HashSet<String> visited = new HashSet<>();
        //visited.add("0-0");
        int m = grid.length;
        int n = grid[0].length;
        while(!q.isEmpty()) {
            int size = q.size();
            
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];
            int level = current[2];
            if(i == m - 1 && j == n - 1) {
                return level;
            }
            for(int[] dir :dirs ) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(x >=0 && x<m && y>=0 && y<n && grid[x][y] !=1 && !visited.contains(x+"-"+y)) {
                    visited.add(x+"-"+y);
                    q.add(new int[]{x, y, level+1});
                }
            }
        }
        return -1;
    }
}