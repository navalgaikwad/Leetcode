class Solution {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        int cur_sum = 0;
        int max_window = -1;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            cur_sum += nums[r];

            while (l <= r && cur_sum > target) {
                cur_sum -= nums[l];
                l++;
            }

            if (cur_sum == target) {
                max_window = Math.max(max_window, r - l + 1);
            }
        }

        return max_window == -1 ? -1 : nums.length - max_window;
    }
}
