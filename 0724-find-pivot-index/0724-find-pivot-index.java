class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int total = Arrays.stream(nums).sum();
        int i = 0;
        while( i < nums.length) {
            if(leftSum == total - leftSum - nums[i]) {
                return i;
            }
            leftSum+=nums[i];
            i++;
        }
        return -1;
    }
}