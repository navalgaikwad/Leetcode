Check if the largest element in nums is greater than the target sum. If yes, return False.
Create an array subset_sums with k elements initialized to 0.
Define a recursive function backtrack(index) that takes an index as input.
Base case: If index is equal to the length of nums, return True.
For each subset i from 0 to k-1:
If subset_sums[i] + nums[index] is less than or equal to target_sum, add nums[index] to subset_sums[i].
Recursively call backtrack(index+1).
If the recursive call returns True, return True.
Otherwise, subtract nums[index] from subset_sums[i].
If subset_sums[i] is equal to 0, break out of the loop and return False.
Call backtrack(0) and return the result.
public boolean canPartitionKSubsets(int[] nums, int k) {
int numsSum = Arrays.stream(nums).sum();
​
if (numsSum % k != 0) {
return false;
}
​
int targetSum = numsSum / k;
Arrays.sort(nums);
if (nums[nums.length - 1] > targetSum) {
return false;
}
​
int[] subsetSums = new int[k];
​
return backtrack(nums, subsetSums, targetSum, 0);
}
​
private boolean backtrack(int[] nums, int[] subsetSums, int targetSum, int index) {
if (index == nums.length) {
return true;
}
​
for (int i = 0; i < subsetSums.length; i++) {
if (subsetSums[i] + nums[index] <= targetSum) {
subsetSums[i] += nums[index];
if (backtrack(nums, subsetSums, targetSum, index + 1)) {
return true;
}
subsetSums[i] -= nums[index];
}
if (subsetSums[i] == 0) {
break;
}
}
​
return false;
}
​