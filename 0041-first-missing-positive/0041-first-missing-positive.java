class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean seen[] = new boolean[length + 1];
        for(int i=0; i<length; i++) {
            if(nums[i] > 0 && nums[i] <= length) {
                seen[nums[i]] = true;
            }
        }
        for(int i =1; i<=length; i++) {
            if(!seen[i]) {
                return i;
            }
        }
        return length + 1;
    }
}
