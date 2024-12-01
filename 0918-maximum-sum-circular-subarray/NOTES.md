class Solution {
public int maxSubarraySumCircular(int[] nums) {
int noncyclic = maxSum(nums);
int totalSum = 0;
for(int i=0; i<nums.length ;i++) {
totalSum +=nums[i];
nums[i] = -nums[i];//minus swatashi karnar
}
int circular  = totalSum + maxSum(nums);
if(circular == 0 ) {
return noncyclic;
}
return Math.max(noncyclic, circular); // max of both cyclic and non cyclic
}
int maxSum(int[] nums) {
int sum =nums[0];
int max = nums[0];
for(int i =1; i<nums.length; i++) {
if(sum < 0){
sum =0;
}
sum = sum + nums[i];
max =Math.max(max, sum);
}
return max;
}
}