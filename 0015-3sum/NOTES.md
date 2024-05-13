class Solution {
public List<List<Integer>> threeSum(int[] nums) {
Arrays.sort(nums);
List<List<Integer>> result = new ArrayList<>();
for(int i=0; i < nums.length - 2; i++) {
int left = i + 1;
int right = nums.length - 1;
while(left < right) {
int total = nums[i] + nums[left] + nums[right];
if(total == 0) {
result.add(Arrays.asList(nums[i], nums[left], nums[right]));
while(left < right && nums[left] == nums[left+1]) {
left = left + 1;
}
while(left < right && nums[right] == nums[right-1]) {
right = right - 1;
}
left++;
right--;
}else if(total < 0) {
left++;
}else {
right--;
}
}
while(i+1 < nums.length && nums[i] == nums[i+1]) {
i++;
}
}
return result;
}
}