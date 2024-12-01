class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] directions = {{0,-1}, {-1, 0}, {1, 0}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,k, 0});
        Set<String> visited = new HashSet<>();
        visited.add(0+"-"+0+"-"+0);
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];
            int stop = current[2];
            int level = current[3];
            if(i == grid.length-1 && j == grid[0].length-1) {
                return level;
            }
            for(int[] direction :directions) {
                int src = direction[0];
                int dest =direction[1];
                int x = i + src;
                int y = j + dest;
                if(x >=0 && x <grid.length && y>=0 && y < grid[0].length && stop>=0 && !visited.contains(x+"-"+y+"-"+stop)) {
                     int val = stop - grid[x][y];
                    q.add(new int[]{x, y, val, level+1});
                    visited.add(x+"-"+y+"-"+(stop));
                }
            }
        }
        return -1;
    }
}