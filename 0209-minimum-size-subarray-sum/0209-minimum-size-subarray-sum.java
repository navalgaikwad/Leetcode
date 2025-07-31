class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
      //  int end = nums.length-1;
        int sum = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;
        for(int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            while(sum >= target) {
                len = Math.min(len, end - start + 1);
                sum-=nums[start];
                start++;
            }

        }
        return len == Integer.MAX_VALUE? 0 : len;
    }
}