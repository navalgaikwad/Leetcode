class Solution {
    public int jump(int[] nums) {
        if(nums.length<2) return 0;
        return dp(nums, 0, new HashMap<>());
    }
    
    int dp(int[] nums, int currentPosition, HashMap<Integer,Integer> memo){
        if(memo.containsKey(currentPosition)){
            return memo.get(currentPosition);
        }
        if(currentPosition == nums.length -1){
            return 0;
        }
        
        int minCoin = -1;
        for(int coin = 1; coin<nums[currentPosition] +1; coin++){
            int nextPosition = coin + currentPosition;
            if(nextPosition < nums.length){
                int jump = dp(nums, nextPosition, memo);
                if(jump != -1){
                    int newJump = jump + 1;
                    if(minCoin == -1 || newJump < minCoin){
                        minCoin = newJump;
                    }
                }
            }
        }
        memo.put(currentPosition, minCoin);
       return  minCoin;
    }
}