class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] visited = new boolean[lastDay + 1];
        dp[0] = 0;
        for (int day : days) {
            // if(day > 0) {
            visited[day] = true;
            // }
        }
        for (int i = 1; i <= lastDay; i++) {
            if (!visited[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = cost[0] + dp[i - 1];
            dp[i] = Math.min(cost[1] + dp[Math.max(i - 7, 0)], dp[i]);
            dp[i] = Math.min(cost[2] + dp[Math.max(i - 30, 0)], dp[i]);
        }
        return dp[lastDay];

    }
}