class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left =0;
        int max = 0;
        long curr = 0;
        for(int right =0; right < nums.length; right++) {
            int target = nums[right];
            curr+=target;
            
            while(((right - left + 1)*(long) target) > k + curr) {
                curr-= nums[left];;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
