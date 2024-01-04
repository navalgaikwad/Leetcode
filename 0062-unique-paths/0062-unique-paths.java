class Solution {
    public int uniquePaths(int m, int n) {
       // Integer[][] memo = new Integer[m][n];
        HashMap<String, Integer> memo = new HashMap<>();
        return memoDP(m - 1, 0, m, n, memo);
    }

    private int memoDP(int i, int j, int m, int n, HashMap<String, Integer> memo) {
        String key = i+"-"+j;
        if (i == 0 && j == n - 1) {
            return 1;
        }
        if (i < 0 || j >= n) {
            return 0;
        }
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int down = memoDP(i - 1, j, m, n, memo);
        int right = memoDP(i, j + 1, m, n, memo);
        memo.put(key, down + right) ;
        return down + right;
    }
}
