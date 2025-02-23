class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closedSum = Integer.MAX_VALUE/2;
        for(int i=0; i<nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(closedSum - target)) {
                    closedSum = sum;
                }else if(sum <  target) {
                    left++;
                }else if(sum > target) {
                    right--;
                }else {
                    return closedSum;
                }

            }
           // return closest_sum;
        }
         return closedSum;
        
    }
}

/*
closedSum = -1000, -2
nums = [-1,2,1,-4], target = 1
-4,-1,1,2

-4 -1 + 2 = -3

-3 + 1 < -100 + 1
-2 < 99



*/