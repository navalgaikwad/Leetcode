class Solution {
public int[] answerQueries(int[] nums, int[] queries) {
Arrays.sort(nums);
for(int i=1;i<nums.length;i++) //replace nums array with prefixSum
nums[i]= nums[i-1]+nums[i];
for(int i=0;i<queries.length;i++)  //replace queries array with answer
queries[i] = find(nums,queries[i]);
​
return queries;
​
}
​
public int find(int[] arr, int target) //binary search
{
int l = 0, r=arr.length-1;
while(l<=r)
{
int mid = l+(r-l)/2;
if(target==arr[mid])
return mid+1;
​
else if(target>arr[mid])
l=mid+1;
​
else
r=mid-1;
​
}
return l;
}
​
}
java
sorti