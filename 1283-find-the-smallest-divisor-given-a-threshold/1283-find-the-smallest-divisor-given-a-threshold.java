class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        int result =right;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(helper(nums, threshold, mid)) {
                result = mid;
                right = mid - 1;
            }else {
                
                left = mid + 1;
            }
        }
        return result;
    }
    
     boolean helper(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / divisor);
        }
        return sum <= threshold;
    }
}