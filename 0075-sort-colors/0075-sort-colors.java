class Solution {
     public void sortColors(int[] nums) {
        int lt = 0, i = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] == 0) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, gt);
                gt--;
            } else { // nums[i] == 1
                i++;
            }
        }
    }
    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

}

