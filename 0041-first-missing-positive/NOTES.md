public int findMissingPositive(int[] nums) {
int n = nums.length;
for (int i = 0; i < nums.length; i++) {
if (nums[i] <= 0 || nums[i] >= n) {
nums[i] = 0;
}
}
​
for (int i = 0; i < nums.length; i++) {
nums[nums[i] % n] += n;
}
​
for (int i = 1; i < nums.length; i++) {
if (nums[i] / n == 0) {
return i;
}
}
​
return n;
}
​