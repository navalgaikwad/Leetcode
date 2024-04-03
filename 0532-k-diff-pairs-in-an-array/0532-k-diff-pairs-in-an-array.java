class Solution {
    public int findPairs(int[] nums, int k) {
        int i = 0;
        int j = 1;
        int sum = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int count =0;
        while(i < nums.length && j < nums.length) {
            if(nums[j] - nums[i] == k && nums[i] + nums[j]!=sum) {
                sum = nums[i] + nums[j];
                count++;
            }
            if(nums[j] - nums[i] < k) {
                j++;
            }else {
                i++;
            }
            if(i == j) {//if on same index
                j++;
            }
        }
        return count;
    }
}

/*
1. to avoid duplicate nums[i]+nums[j]!=sum
2. if both apear to same index increament j++ 

*/