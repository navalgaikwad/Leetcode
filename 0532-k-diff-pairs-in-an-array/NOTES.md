public class Solution {
public int findPairs(int[] nums, int k) {
if (nums == null || nums.length == 0 || k < 0)   return 0;
Map<Integer, Integer> map = new HashMap<>();
int count = 0;
for (int i : nums) {
map.put(i, map.getOrDefault(i, 0) + 1);
}
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
if (k == 0) {
//count how many elements in the array that appear more than twice.
if (entry.getValue() >= 2) {
count++;
}
} else {
if (map.containsKey(entry.getKey() + k)) {
count++;
}
}
}
return count;
}
}
​
class Solution {
public int findPairs(int[] nums, int k) {
int i =0;
int j =1;
int count =0;
Arrays.sort(nums);
int sum = Integer.MIN_VALUE;
while( i < nums.length && j < nums.length) {
if(nums[j] - nums[i] == k && nums[i] + nums[j] != sum) {
sum = nums[i] + nums[j];
count++;
}
if(nums[j] - nums[i] < k) {
j++;
}else {
i++;
}
if(i == j) {
j++;
}
}
return count;
}
}