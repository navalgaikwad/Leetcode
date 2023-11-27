class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0]==0 && nums.length<2) return true;
        return dp(nums, 0, new HashMap<>());
    }
    boolean dp(int[] nums, int currentIndex, HashMap<Integer, Boolean> memo){
        if(currentIndex==nums.length -1){
            return true;
        }
        if(memo.containsKey(currentIndex)) return memo.get(currentIndex);
        
        for(int i = 1; i< nums[currentIndex]+1; i++){
            int nextStep = i + currentIndex;
            if(nextStep < nums.length){
               if(dp(nums, nextStep, memo)){
                memo.put(currentIndex, true);
                return true;
            } 
          }
            
        }
        memo.put(currentIndex, false);
        return false;
    }
}