class Solution {
    public int splitArray(int[] nums, int k) {
        // The minimum possible value for the largest sum is the maximum number in the array,
        // since each number must be in one of the subarrays.
        int low = Arrays.stream(nums).max().getAsInt();
        // The maximum possible value for the largest sum is the sum of all numbers in the array,
        // which would be the case if all numbers are in one subarray.
        int high = Arrays.stream(nums).sum();
        int ans = 0; // This will store the final answer.

        // Binary search between the low (max number) and high (sum of all numbers) bounds.
        while(low <= high) {
            // Calculate the midpoint which represents the maximum sum we are trying to verify.
            int mid = low + (high - low) / 2;

            // Check if it is possible to split the array into k or fewer parts without any part
            // having a sum greater than mid.
            if(check(nums, k, mid)){
                ans = mid; // If it's possible, this could be the right answer.
                high = mid - 1; // We try to see if there is a smaller possible maximum sum.
            }
            else{
                low = mid + 1; // If not possible, we need a larger maximum sum.
            }
        }
        return ans; // Return the smallest possible maximum sum.
    }
    
    // Helper function to check if it's possible to split the array into k or fewer parts
    // such that the sum of each part is less than or equal to mid.
    boolean check(int[] nums, int k, int mid) {
        int sum = 0; // Current sum of the ongoing subarray.
        int count = 1; // Start with one subarray.

        for(int num : nums) {
            sum += num; // Add the current number to the ongoing subarray sum.

            // If the current sum exceeds mid, we need to start a new subarray.
            if(sum > mid) {
                count++; // Increment the subarray count.
                sum = num; // The new subarray starts with the current number.
            }
        }
        // Return true if we can split the array into k or fewer such subarrays.
        return count <= k;
    }
}
