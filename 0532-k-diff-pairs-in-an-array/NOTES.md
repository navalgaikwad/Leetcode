return count;
}
}
​
class Solution {
public int findPairs(int[] nums, int k) {
Arrays.sort(nums);
int left =0;
int right = 1;
int count = 0;
int sum = Integer.MIN_VALUE;
while(left < nums.length && right < nums.length) {
if(nums[right] - nums[left] == k && sum!= nums[right] + nums[left]) {
sum = nums[right] + nums[left];
count++;
}
if(nums[right] - nums[left] < k) {
right++;
}else {
left++;
}
if(left == right) {
right++;
}
}
return count;
}
}