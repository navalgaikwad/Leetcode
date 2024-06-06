class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans =0;
        int c = 0;
        for(int i=0; i<nums.length - 2; i++) {
            if(nums[i + 1] - nums[i] == nums[i + 2]- nums[i + 1]) {
                c++;
            }else {
                c =0;
            }
            ans+=c;
        }
        return ans;
    }
}
