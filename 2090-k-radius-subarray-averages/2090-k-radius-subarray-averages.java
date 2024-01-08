class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        long[] prefix = new long[len];
        long[] suffix = new long[len];
        prefix[0] = nums[0];
        for(int i = 1; i<len; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        suffix[len-1] = nums[len-1];
        for(int i =len-2; i>=0; i--) {
            suffix[i] = suffix[i+1]+nums[i];
        }
        
        int[] result = new int[len];
        for(int i=0; i<len; i++) {
            if(i-k <0 || i+k >=len) {
                result[i] = -1;
            }else {
                long suffixValue = suffix[i-k] - suffix[i];
                long prefixValue = prefix[i+k] - prefix[i];
                long sum = suffixValue + prefixValue + (long)nums[i];
                long noEle = (2*k + 1);
                long avg = sum/noEle;
                result[i] = (int)avg;
            }
        }
        return result;
    }
}