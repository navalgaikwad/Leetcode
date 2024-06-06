class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        // The maximum possible value for the largest sum is the sum of all numbers in the array,
        // which would be the case if all numbers are in one subarray.
        int right = Arrays.stream(nums).sum();
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            int sum = 0;
            int count =1;
            for(int i=0; i<nums.length; i++) {
                sum = sum + nums[i];
                if(sum > mid) {
                    count++;
                    sum = nums[i];
                }
            }
            if(count<=k) {
                ans = mid;
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
}