class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for(int num : nums) {
            right = Math.max(num, right);
        }
        int result = right;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(helper(nums, mid, threshold)) {
                result = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    boolean helper(int[] nums, int mid, int threshold) {
        int sum = 0;
        for(int num : nums) {
            sum += Math.ceil((double) num/ mid);
        }
        return sum <=threshold;
    }
}
//do binary search
//take right max value from array
//and left = 0