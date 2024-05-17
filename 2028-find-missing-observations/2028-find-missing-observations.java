class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int curSum = Arrays.stream(rolls).sum(), m = rolls.length;
        int missingSum = mean * (n + m) - curSum;
        if (missingSum < n || missingSum > 6*n) return new int[0];

        int part = missingSum / n, rem = missingSum % n;
        int[] ans = new int[n];
        Arrays.fill(ans, part);
        for (int i = 0; i < rem; ++i)
            ++ans[i];
        return ans;
    }
}