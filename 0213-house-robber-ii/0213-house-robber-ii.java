class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len<2){
            return nums[0];
        }
      

        // Copy the array from index 2 to the last index
        int[] copy1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] copy2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        
        int firstRob = dp(copy1, len - 2, new HashMap<>());
        int secondRob = dp(copy2, len - 2, new HashMap<>());
        return Math.max(firstRob, secondRob);
    }
    
    int dp(int[] nums, int currentSteps, HashMap<Integer, Integer> memo){
        if(currentSteps == 0){
            return nums[currentSteps];
        }
        if(currentSteps < 0){
            //return Math.max(nums[0], nums[1]);
            return 0;
        }
        if(memo.containsKey(currentSteps)) return memo.get(currentSteps);
        
        int currentRob = dp(nums, currentSteps - 2, memo) + nums[currentSteps];
        int previousRob = dp(nums, currentSteps - 1, memo);
        int val = Math.max(currentRob, previousRob);
        memo.put(currentSteps, val);
        return val;
    }
    
    //  int dp2(int[] nums, int start){
    //     if(start == 1){
    //         return nums[start];
    //     }
    //     if(start == 2){
    //         return Math.max(nums[1], nums[2]);
    //     }
    //     int currentRob = dp2(nums, start - 2) + nums[start - 2];
    //     int previousRob = dp2(nums, start - 1);
    //     return Math.max(currentRob, previousRob);
    // }
}