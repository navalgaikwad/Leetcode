boolean dp(int[] nums, int currentIndex, HashMap<Integer, Boolean> memo){
if(currentIndex == nums.length -1){
return true;
}
if(memo.containsKey(currentIndex)) return memo.get(currentIndex);
for(int coin = 1; coin< nums[currentIndex] + 1; coin++){
int nextStep = coin + currentIndex; // it is same as coin change
//move to next step
if(nextStep < nums.length){//check for nextstep is less than array length
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
​
class Solution {
public boolean canJump(int[] nums) {
int len = nums.length+1;
int[] dp = new int[len];
Arrays.fill(dp, -1);
dp[0] = 1;
for(int i=0; i< nums.length; i++) {
if(dp[i] != -1) {
for(int j=1; j<=nums[i]; j++) {
int next = j + i;//use j not dp[j] or dp[i]
if(next < len) {
dp[next] =  dp[i] + 1;
}
}
}
}
return dp[nums.length - 1] != -1;
}
}
​
// class Solution {
//     public boolean canJump(int[] nums) {
//         int len = nums.length;
//         int[] dp = new int[len];
//         Arrays.fill(dp, -1);
//         dp[0] = 1;
//         for (int i = 0; i < nums.length; i++) {
//             if (dp[i] != -1) {
//                 for (int j = 1; j <= nums[i]; j++) {
//                     int next = j + i;
//                     if (next < len) {
//                         dp[next] = dp[i] + 1;