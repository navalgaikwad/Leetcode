class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        int left  = 0;
        int right = 1;
        int count=0;
        while(right < nums.length) {
            if(nums[right] - nums[left] == k && sum != nums[right] + nums[left]) {
                sum = nums[left] + nums[right];
                count++;
            }
            if(nums[right] - nums[left] < k) {
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