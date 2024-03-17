}
​
​
//same as unfairness
public boolean canPartitionKSubsets(int[] nums, int k) {
int sum = Arrays.stream(nums).sum();
if(sum%k!=0) {
return false;
}
int target = sum/k;
Arrays.sort(nums);
if(nums[nums.length-1] > target) {
return false;
}
int[] subSet = new int[k];
return backTracking(nums, subSet, target, 0, k);
}
boolean backTracking(int[] nums, int[] subSet, int target, int index, int k) {
if(index == nums.length) {//main index
return true;
}
for(int i = 0; i < k; i++) {
if(subSet[i] + nums[index] <=target) {
subSet[i] = subSet[i] + nums[index];
if(backTracking(nums, subSet, target, index+1, k)){
return true;
}
subSet[i] = subSet[i] - nums[index];
}
if(subSet[i] == 0) {
break;
}
}
return false;
}