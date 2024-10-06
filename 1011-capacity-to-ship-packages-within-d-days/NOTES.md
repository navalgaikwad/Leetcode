```
class Solution {
public int shipWithinDays(int[] weights, int days) {
int left = Arrays.stream(weights).max().getAsInt();//10
int right = Arrays.stream(weights).sum();//sum
int ans =0;
while(left <= right) {
int mid = left + (right - left)/2;
if(check(weights, days, mid)) {
ans = mid;
right = mid -1;
}else {
left = mid + 1;
}
}
return ans;
}
boolean check(int[] weights, int days, int mid) {
int sum =0;
int count=1;
for(int weight : weights) {
sum+=weight;
if(sum > mid) {
count++;
sum = weight;
}
}
return count<=days;
}
}
```
[Template](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/discuss/2327257/Template-or-One-code-works-for-all-Problems)