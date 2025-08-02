class Solution {
    public int longestSubarray(int[] nums) {
        int left =0;
        int countZero=0;
        int len =0;
        for(int right =0; right <nums.length; right++) {
            if(nums[right]==0) {
                countZero++;
            }
            while(countZero > 1) {
                if(nums[left] == 0) {
                    countZero--;
                }
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        return len - 1;
    }
}