class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0;
        long currentSum =0;
        int max =0;
        for(int right =0; right < nums.length; right++) {
            int target = nums[right];
            currentSum+=target;
            
            if(((right - left + 1) * (long)target)> k + currentSum) {
                currentSum-=nums[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}