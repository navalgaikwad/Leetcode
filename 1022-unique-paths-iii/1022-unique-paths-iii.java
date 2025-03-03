import java.util.*;

class Solution {
    private int dfs(int[][] grid, int i, int j, int cnt, int totalCnt, int M, int N, List<List<int[]>> res, List<int[]> path) {
        if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == -1) {
            return 0;
        }
        
        path.add(new int[]{i, j});
        
        if (grid[i][j] == 2) {
            if (cnt == totalCnt) {
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return (cnt == totalCnt) ? 1 : 0;
        }

        grid[i][j] = -1; // Mark as visited
        int ans = dfs(grid, i + 1, j, cnt + 1, totalCnt, M, N, res, path);
        ans += dfs(grid, i - 1, j, cnt + 1, totalCnt, M, N, res, path);
        ans += dfs(grid, i, j + 1, cnt + 1, totalCnt, M, N, res, path);
        ans += dfs(grid, i, j - 1, cnt + 1, totalCnt, M, N, res, path);
        
        grid[i][j] = 0; // Unmark for backtracking
        path.remove(path.size() - 1);
        return ans;
    }

    public int uniquePathsIII(int[][] grid) {
        int startI = 0, startJ = 0, totalCnt = 0;
        int M = grid.length, N = grid[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
                if (grid[i][j] != -1) {
                    totalCnt++;
                }
            }
        }

        List<List<int[]>> res = new ArrayList<>();
        List<int[]> path = new ArrayList<>();
        return dfs(grid, startI, startJ, 1, totalCnt, M, N, res, path);
    }
}