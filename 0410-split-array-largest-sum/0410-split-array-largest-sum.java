class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(helper(nums, k, mid)) {
                ans = mid;
                right = mid - 1; 
            }else {
                left = mid + 1; 
            }
        }
        return ans;
    }
    
    boolean helper(int[] nums, int k, int mid) {
        int subcount = 1;
        int sum = 0;
        for(int i = 0; i<nums.length; i++) {
            sum = sum + nums[i];
            if(sum > mid) {
                subcount++;
                sum = nums[i];
            }
        }
        
        return subcount <= k;
    }
}

//[7,2,5,10,8]
//[]
//int left = min
//int 
//find low and high