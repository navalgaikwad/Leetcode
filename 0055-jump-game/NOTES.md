class Solution {
public boolean canJump(int[] nums) {
return dp(nums, 0);
}
boolean dp(int[] nums, int currentIndex){
if(currentIndex==nums.length){
return true;
}
if(nums[currentIndex]==0){
return false;
}
int val = nums[currentIndex];
for(int i = currentIndex; i<=val; i++){
int min = Math.min(i + 1, nums.length);
if(!dp(nums, min)){
return false;
}
}
return true;
}
}
moving one step at a time