class Solution {

    // [1, 2, 10, 5, 7
    public boolean canBeIncreasing(int[] nums) {
        int dip = 0;
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= previous) {
                if(++dip == 2) {
                    return false;
                }else if(i == 1 || nums[i] > nums[i-2]) {
                    previous = nums[i];
                }
            }else {
                previous = nums[i];
            }
        }
        return true;
    }
}