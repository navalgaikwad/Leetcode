class Solution {
    public int minStartValue(int[] nums) {
        int cumalativesum = 0;
        int steps =0;
        for(int i = 0; i<nums.length; i++) {
            cumalativesum = cumalativesum+nums[i];
            steps = Math.min(steps, cumalativesum);
        }
        return 1 - steps;
    }
}