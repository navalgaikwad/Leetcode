class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros =0;
        int left =0;
        int result =0;
        for(int right =0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeros++;
            }
            while(zeros > k) {
                if(nums[left] == 0) {
                 zeros--;
              }
                left++;
            }
            result = Math.max(result, right - left  +1);
        }
        return result;
    }
}