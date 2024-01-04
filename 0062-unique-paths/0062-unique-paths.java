class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return memoDP(m - 1, 0, m, n, memo);
    }

    private int memoDP(int i, int j, int m, int n, Integer[][] memo) {
        if (i == 0 && j == n - 1) {
            return 1;
        }
        if (i < 0 || j >= n) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int down = memoDP(i - 1, j, m, n, memo);
        int right = memoDP(i, j + 1, m, n, memo);
        memo[i][j] = down + right;
        return memo[i][j];
    }
}
