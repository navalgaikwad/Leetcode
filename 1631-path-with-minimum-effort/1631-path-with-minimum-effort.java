class Solution {
    int m =0;
    int n=0;
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int left =0;
        int right=0;
        for (int[] row: heights) {
            for (int num: row) {
                right = Math.max(right, num);
            }
        }
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(check(heights, mid, 0, 0, new boolean[m][n])) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    boolean check(int[][] heights, int mid, int i, int j, boolean[][] visited) {
        if( i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        for(int[] dir:dirs) {
            int x = dir[0]+i;
            int y = dir[1] + j;
            if( x>=0 && x < m && y >=0 && y < n && !visited[x][y] && Math.abs(heights[i][j] - heights[x][y]) <= mid) {
                if(check(heights, mid, x, y, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}