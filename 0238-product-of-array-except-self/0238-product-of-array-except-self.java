class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postFix = new int[nums.length];
        int n = nums.length;
        postFix[n - 1] = 1;////vv important
        for(int i = n-2; i>=0; i--) {
            postFix[i] = postFix[i + 1] * nums[i + 1];
        }
        prefix[0] = 1;//vv important
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i - 1]*nums[i - 1];
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = postFix[i] * prefix[i];
        }
        return result;
    }
}

//[1,2,3,4]
//prefix 1, 1, 2, 6
//suffix 24,12,4, 1