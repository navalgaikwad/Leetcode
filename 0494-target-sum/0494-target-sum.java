class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         Map<String, Integer> memo = new HashMap<>();
        return dp(nums, target, nums.length - 1, 0, memo);
    }

    int dp(int[] nums, int target, int index, int sum, Map<String, Integer> memo) {
       String key = index+"-"+sum;
        if(index < 0 && sum == target) {
            return 1;
        }
        if(index < 0) {
            return 0;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int plus = dp(nums, target, index - 1, sum + nums[index], memo);
        int minus = dp(nums, target, index - 1, sum - nums[index], memo);

        int total = plus + minus;
        memo.put(key, total);
        return memo.get(key);
    }
}