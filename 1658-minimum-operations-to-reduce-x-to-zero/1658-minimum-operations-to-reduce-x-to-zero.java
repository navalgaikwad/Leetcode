class Solution {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        int left = 0, sum = 0, len = nums.length;
        int result = -1;  // Use MIN_VALUE for initial comparison

        for (int right = 0; right < len; right++) {
            sum += nums[right];

            // Shrink the window when sum exceeds or equals target
            while (left <= right && sum > target) {
                
                sum -= nums[left];
                left++;
              
            }
              if (sum == target) {
                    result = Math.max(result, right - left + 1);
                } 
        }

        return result == -1 ? -1 : len - result;
    }
}


