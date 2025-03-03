import java.util.*;

class Solution {
    private int findIfPos(int[] preSum, int k, int idx, int rem, int[][] dp) {
        if (rem == 0)
            return 0;
        if (idx >= preSum.length)
            return Integer.MIN_VALUE;
        if (dp[idx][rem] != -1)
            return dp[idx][rem];

        int take = preSum[idx] + findIfPos(preSum, k, idx + k, rem - 1, dp);
        int notTake = findIfPos(preSum, k, idx + 1, rem, dp);

        return dp[idx][rem] = Math.max(take, notTake);
    }

    private void findIdx(int[] preSum, int k, int idx, int rem, List<Integer> result, int[][] dp) {
        if (rem == 0 || idx >= preSum.length)
            return;

        int take = preSum[idx] + findIfPos(preSum, k, idx + k, rem - 1, dp);
        int notTake = findIfPos(preSum, k, idx + 1, rem, dp);

        if (take >= notTake) {
            result.add(idx);
            findIdx(preSum, k, idx + k, rem - 1, result, dp);
        } else {
            findIdx(preSum, k, idx + 1, rem, result, dp);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length - k + 1;

        // Calculate prefix sums for subarrays of size k
        int[] preSum = new int[n];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (i >= k)
                curSum -= nums[i - k];
            if (i >= k - 1)
                preSum[i - k + 1] = curSum;
        }

        // Initialize DP table
        int[][] dp = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Find the indices
        findIdx(preSum, k, 0, 3, result, dp);

        // Convert List<Integer> to int[]
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    // public static void main(String[] args) {
    // Solution solution = new Solution();
    // int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
    // int k = 2;
    // int[] result = solution.maxSumOfThreeSubarrays(nums, k);
    // System.out.println(Arrays.toString(result)); // Output: [0, 3, 5]
    // }
}