class Solution {
public int rob(int[] nums) {
//         int n = nums.length;
//         if(n<2){
//             return nums[0];
//         }
//         int[] dp = new int[n +1];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);
//         for(int i=2; i<n; i++) {
//             int alternate = dp[i - 2] + nums[i];
//             int previous = dp[i - 1];
//             dp[i] = Math.max(alternate, previous);
//         }
//         return dp[n - 1];
int n = nums.length;
return dp(nums, n - 1, new HashMap<>());
}
int dp(int[] nums, int i, HashMap<Integer, Integer> memo) {
if(memo.containsKey(i)) return memo.get(i);
if(i == 0) {
return nums[i];
}
if(i == 1) {
return Math.max(nums[0], nums[1]);
}
int current = nums[i] + dp(nums, i -2, memo);
int previous = dp(nums, i -1, memo);
int result = Math.max(current, previous);
memo.put(i, result);
return result;
}
}