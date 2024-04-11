class Solution {
    public int rob(int[] nums) {
         int len = nums.length;
        if(len<2){
            return nums[0];
        }
        int[] a = Arrays.copyOfRange(nums, 1, nums.length);
        int[] b = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int first = dp(a, len - 2, new HashMap<>());
        int second = dp(b, len - 2, new HashMap<>());
        return Math.max(first, second);
    }
    
    int dp(int[] nums, int start, HashMap<Integer, Integer> memo) {
        if(start == 0) {
            return nums[start];
        }
        if(start < 0) {
            return 0;
        }
        if(memo.containsKey(start)) {
            return memo.get(start);
        }
        int current = dp(nums, start - 2, memo) + nums[start];
        int previous = dp(nums, start - 1, memo);
        int max = Math.max(current, previous);
        memo.put(start, max);
        return max;
    }
}