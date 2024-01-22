class Solution {
//     public int rob(int[] nums) {
//         int len = nums.length;
//         int[] dp = new int[len + 1];
//          if(len<2){
//             return nums[0];
//         }
//         //Arrays.fill(dp , 0);
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);
//         for(int i = 2; i < len; i++) {
//             int currentRobAndPrevious = nums[i] + dp[i - 2];
//             int previous = 0 + dp[i-1];
//             dp[i] = Math.max(currentRobAndPrevious, previous);
//         }
        
//         return dp[len - 1];
//     }
     public int rob(int[] nums) {
         if (nums.length == 0) {
            return 0;
        }
		int size = nums.length;
		// int[] dp = new int[size];
		// Arrays.fill(dp, -1);
		return dp(nums, size - 1, new HashMap<>());
     }
    
    int dp(int[] nums, int i, HashMap<Integer, Integer> memo) {
        if( i== 0) {
            return nums[0];
        }
        if(i < 0) {
            return 0;
        }
        if(memo.containsKey(i)) {
            return memo.get(i);
        }
        int currentAndPrevious = nums[i] + dp(nums, i - 2, memo);
        int previous = 0 + dp(nums, i - 1, memo);
        int result = Math.max(currentAndPrevious, previous);
        memo.put(i, result);
        return result;
    }
}