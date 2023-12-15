class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Find the largest single weight as the lower bound (left), because the ship needs to be
        // able to carry at least the heaviest package.
        int left = Arrays.stream(weights).max().getAsInt();
        // Find the sum of all weights as the upper bound (right), because the ship should also
        // be able to carry all packages at once.
        int right = Arrays.stream(weights).sum();
        int ans = 0; // This will store the final answer.

        // Binary search to find the least weight capacity.
        while(left <= right) {
            // Check the middle value between the current bounds.
            int mid = left + (right - left) / 2;
            
            // Check if the current capacity (mid) allows us to ship within days.
            if(checkCapacity(weights, days, mid)) {
                ans = mid; // If it's possible, this could be our answer.
                right = mid - 1; // Try to find a smaller capacity that still works.
            } else {
                left = mid + 1; // If not possible, we need a larger capacity.
            }
        }
        return ans; // Return the least weight capacity found.
    }
    
    // Helper method to check if the current capacity allows shipping within the given days.
    boolean checkCapacity(int[] weights, int days, int mid) {
        int capacity = 1; // Start with the first day.
        int sum = 0; // This will accumulate the weight of packages for the current day.

        for(int weight : weights) {
            sum += weight; // Add package weight to the current day's load.
            // If the current day's load exceeds the capacity, we need to use an additional day.
            if(sum > mid) {
                capacity++; // Increment the day count.
                sum = weight; // Start the next day with the current package.
            }
        }
        // Return true if the number of days needed is less than or equal to the allowed days.
        return capacity <= days;
    }
}
