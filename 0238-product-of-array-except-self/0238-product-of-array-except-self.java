class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] suffix = new int[len];
        int[] prefix = new int[len];
        suffix[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        prefix[0] = 1;
        for(int i =1; i<len; i++) {
            prefix[i] = prefix[i-1] * nums[i - 1];
        }
       
         int[] result = new int[len];
         for (int i = 0; i < len; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
        //return new int[]{};
    }
}