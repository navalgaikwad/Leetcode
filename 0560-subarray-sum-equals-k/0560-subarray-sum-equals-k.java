class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1); // To handle the case when the sum equals k at the beginning

        for (int num : nums) {
            sum += num;
            // Check if there is a subarray (ending at the current index) whose sum equals k
            if (sumFrequency.containsKey(sum - k)) {
                count += sumFrequency.get(sum - k);
            }
            // Update the frequency of the current sum
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
