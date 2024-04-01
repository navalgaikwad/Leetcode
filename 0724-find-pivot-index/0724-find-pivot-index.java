class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length;
        int leftSum = 0;
        int total = Arrays.stream(nums).sum();
        
        while(left < right) {
            if(leftSum == total - leftSum - nums[left]) {
                return left;
            }
            leftSum +=nums[left];
            left++;
        }
        return -1;
    }
}