class Solution {
    public int sumOfUnique(int[] nums) {
        int totalsum = 0, n = nums.length;
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        for (int num : nums) {
            if (count[num] == 1) {
                totalsum += num;
            }
        }

        return totalsum;
    }
}