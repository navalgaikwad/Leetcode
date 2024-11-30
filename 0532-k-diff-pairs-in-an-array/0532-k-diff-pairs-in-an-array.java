class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Integer.MIN_VALUE;
        int left =0, right = 1;
        int count =0;
        while(left < nums.length && right< nums.length) {
            if(nums[right] - nums[left] == k && nums[left] + nums[right]!=sum) {
                sum = nums[left] + nums[right];
                count++;
            }
            if(nums[right] - nums[left] < k ) {
                right++;
            }else {
                left++;
            }
            if(left == right) {
                right++;
            }
        }
        return count;
    }
}