class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count =0;
        long result = 0;
        for(int right =0; right <nums.length;right++) {
            if(nums[right] == 0) {
                count+=1;
                result+=count;
            }else {
                count =0;
            }
        }
        return result;
    }
}