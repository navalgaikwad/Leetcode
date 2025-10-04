class Solution {
    public int findNumbers(int[] nums) {
        int i = 0;
        int max = 0;
        while (i < nums.length) {
            int num = nums[i];
            int count = 0;
            while (num != 0) {
                num = num / 10;
                count++;
            }
            if (count % 2 == 0) {
                max++;
            }
            i++;
        }
        return max;
    }
}