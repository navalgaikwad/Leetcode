class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int pairs = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > k) {
                right--;
            } else if (sum == k) {
                pairs++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        return pairs;
    }
}