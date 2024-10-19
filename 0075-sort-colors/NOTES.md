class Solution {
public void sortColors(int[] nums) {
int p1=0; int p2 = nums.length -1;
int index =0;
while(index <= p2) {
if(nums[index] == 0) {
nums[index] = nums[p1];
nums[p1] = 0;
p1++;
}
if(nums[index] == 2) {
nums[index] = nums[p2];
nums[p2] = 2;
p2--;
index--;
}
index++;
}
}
}