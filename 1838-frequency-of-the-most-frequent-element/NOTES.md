```
(right - left + 1): This calculates the length of the current subarray. right and left are the indices that define the boundaries of your sliding window. (right - left + 1) gives you the number of elements within this window.
​
* target: This part multiplies the length of the subarray by target, which represents the ideal sum of the elements in the subarray. The idea is that if all elements in the subarray were equal to target, the sum of this subarray would be (length of subarray) * target.
​
curr: This variable holds the actual sum of the elements in the current subarray.
​
(right - left + 1) * target - curr: This expression calculates the difference between the ideal sum of the subarray (if all elements were equal to target) and the actual sum of the elements in the current subarray.
```
​
class Solution {
public int maxFrequency(int[] nums, int k) {
Arrays.sort(nums);
int left =0;
int max = 0;
long curr = 0;
for(int right =0; right < nums.length; right++) {
int target = nums[right];
curr+=target;
while(((right - left + 1)*(long) target) > k + curr) {
curr-= nums[left];;
left++;
}
max = Math.max(max, right - left + 1);
}
return max;
}
}
​
/*
This entire expression checks if the product of the number of elements in the range and the target
value is greater than the sum of k and curr.
​
*/