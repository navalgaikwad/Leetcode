class Solution {
    // important learning here
    //to check for Math.abs(heights[i][j] - heights[i + 1][j]) diff not more than mid
    //best one
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
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
             boolean[][] seen = new boolean[m][n];
            if (dfs(heights, 0, 0, mid, seen)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    //run the dfs
    boolean dfs(int[][] heights, int i, int j, int mid, boolean[][] seen) {
    if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || seen[i][j]) {
        return false;
    }
    seen[i][j] = true;
    if (i == heights.length - 1 && j == heights[0].length - 1) {
        return true;
    }

    // Check each direction
    if (i + 1 < heights.length && !seen[i + 1][j] && Math.abs(heights[i][j] - heights[i + 1][j]) <= mid) {
        if (dfs(heights, i + 1, j, mid, seen)) {
            return true;
        }
    }
    if (i - 1 >= 0 && !seen[i - 1][j] && Math.abs(heights[i][j] - heights[i - 1][j]) <= mid) {
        if (dfs(heights, i - 1, j, mid, seen)) {
            return true;
        }
    }
    if (j + 1 < heights[0].length && !seen[i][j + 1] && Math.abs(heights[i][j] - heights[i][j + 1]) <= mid) {
        if (dfs(heights, i, j + 1, mid, seen)) {
            return true;
        }
    }
    if (j - 1 >= 0 && !seen[i][j - 1] && Math.abs(heights[i][j] - heights[i][j - 1]) <= mid) {
        if (dfs(heights, i, j - 1, mid, seen)) {
            return true;
        }
    }

    return false;
}

}