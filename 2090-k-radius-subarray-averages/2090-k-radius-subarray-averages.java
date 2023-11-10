class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        long[] prefix = new long[len];
        long[] suffix = new long[len];
       
        long sumFromStart = 0, sumFromEnd = 0;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            sumFromStart += nums[i];
            sumFromEnd += nums[j];
            prefix[i] = sumFromStart;
            suffix[j] = sumFromEnd;
        }
        int[] result = new int[len];
        //int i =0;
        for(int i=0; i<len; i++){
            if(i - k < 0 || i + k >=len){
               result[i]=-1; 
            }else{ 
                // suffice to find element from left 
                //prefix to find element from right side
                long sum = (suffix[i - k] - suffix[i]) + (long) nums[i] + (prefix[i + k] -prefix[i]);
                sum = sum/(2* k + 1);
                result[i] =(int) sum; // k(left)+ 1 + k (right) 2k + 1
            }
        }
        return result;
    }
}