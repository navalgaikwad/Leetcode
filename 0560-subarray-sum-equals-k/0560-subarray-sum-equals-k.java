class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        int count = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initialize with a prefix sum of 0

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // Check if there exists a subarray with sum (sum - k)
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Update prefix sum count
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
