class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        int lastPositionIndex = len;
        for(int i = len; i>=0; i--){
            int currentPosition = nums[i];
            if(i + currentPosition >= lastPositionIndex){
                lastPositionIndex = i;
            } 
        }
        System.out.print(lastPositionIndex);
        return lastPositionIndex==0;
    }
}