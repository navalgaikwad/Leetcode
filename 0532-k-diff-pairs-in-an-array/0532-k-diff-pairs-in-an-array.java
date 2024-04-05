import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        int i = 0;
        int j = 1;
        int m = 0;
        Arrays.sort(nums);
        while (i < nums.length - 1 && j < nums.length) {
            if (Math.abs(nums[i] - nums[j]) == k) {
                m++;
                int val1 = nums[i];
                int val2 = nums[j];
                // Move to the next different value of nums[i]
                while (i < nums.length && nums[i] == val1) {
                    i++;
                }
                // Move to the next different value of nums[j]
                while (j < nums.length && nums[j] == val2) {
                    j++;
                }
            } else if ((nums[j] - nums[i]) < k) {
                j++;
            } else {
                i++;
            }
            // Ensure i and j are not the same to avoid duplicates
            if (i == j) {
                j++;
            }
        }
        return m;
    }
}
