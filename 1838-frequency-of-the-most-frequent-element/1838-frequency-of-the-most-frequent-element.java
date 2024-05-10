class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0;
        long sum = 0;
        int len = 0;
        for(int right =0; right < nums.length; right++) {
            int target = nums[right];
            sum+=target;
          
            while(((right - left + 1) * (long)target) > k + sum) {
                sum -=nums[left];
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}