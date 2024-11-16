class Solution {
    public int minimumSwaps(int[] nums) {
        int min  = Integer.MAX_VALUE;
        int indexMin = 0;
        int max = Integer.MIN_VALUE;
        int indexMax = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= max) {
                max = nums[i];
                indexMax = i;
            }
             if(nums[i] < min) {
                min = nums[i];
                indexMin = i;
            }
        }
        int len = nums.length-1;
        int maxMove = len - indexMax;
        int result = maxMove + indexMin;
        if(indexMax < indexMin) {
            return result-1; 
        }
        
        return result;
    }
}