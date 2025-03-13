class Solution {
      public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1); // Fill with -1 to indicate uncomputed states
        return dfs(nums, target, dp);
    }

    private int dfs(int[] nums, int target, int[] dp) {
        if (target == 0) return 1; // Found a valid combination
        if (target < 0) return 0;  // Invalid case
        
        if (dp[target] != -1) return dp[target]; // Return cached result

        int count = 0;
        for (int num : nums) {
            count += dfs(nums, target - num, dp);
        }

        dp[target] = count; // Store the result
        return count;
    }

}