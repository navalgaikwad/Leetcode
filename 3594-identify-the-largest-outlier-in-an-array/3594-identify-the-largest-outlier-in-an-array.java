class Solution {
     public int getLargestOutlier(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        // Calculate the sum and frequency of double the values
        for (int n : nums) {
            sum += n;
            freq.put(n * 2, freq.getOrDefault(n * 2, 0) + 1);
        }

        // Check for the largest valid outlier
        for (int n : nums) {
            int t = sum - n;
            if (freq.getOrDefault(t, 0) >= 2 || (freq.getOrDefault(t, 0) == 1 && t != n * 2)) {
                ans = Math.max(ans, n);
            }
        }

        return ans;
    }
}