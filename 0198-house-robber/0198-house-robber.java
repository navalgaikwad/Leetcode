class Solution {
    public int rob(int[] nums) {
      int n = nums.length;
      return dp(nums, n - 1, new HashMap<>());  
    }
    
    int dp(int[] nums, int index, HashMap<Integer, Integer> memo) {
        if(memo.containsKey(index)) {
            return memo.get(index);
        }
        if(index == 0) {
            return nums[0];
        }
        if(index == 1) {
            return Math.max(nums[0], nums[1]);
        }
        int current = nums[index] + dp(nums, index - 2, memo);
        int previous = dp(nums, index - 1, memo);
        
        int result = Math.max(current, previous);
        memo.put(index, result);
        return result;
    }
}