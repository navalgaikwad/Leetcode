class Solution {
public int[] searchRange(int[] nums, int target) {
int value1 = binaryPosition1(nums, 0, nums.length - 1, target);
int value2 = binaryPosition2(nums, 0, nums.length - 1, target);
return new int[]{value2, value1};
}
int binaryPosition1(int[] nums, int start, int end, int target) {
int position = -1;
while(start <= end) {
int mid = start + (end - start)/2;
if(nums[mid] == target) {
position = mid;
}
if(nums[mid] <= target) {
start = mid + 1;
}else {
end = mid - 1;
}
}
return position;
}
int binaryPosition2(int[] nums, int start, int end, int target) {
int position = -1;
while(start <= end) {
int mid = start + (end - start)/2;
if(nums[mid] == target) {
position = mid;
}
if(nums[mid] >= target) {
end = mid - 1;
}else {
start = mid + 1;
}
}
return position;
}
}
​