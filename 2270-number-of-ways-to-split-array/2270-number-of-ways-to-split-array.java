class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long[] maxSumFromStart = new long[len];
        long[] maxSumFromEnd = new long[len];
        // maxSumFromStart = helper1(nums, len);
        // maxSumFromEnd = helper2(nums, len);
       
         long sumFromStart = 0, sumFromEnd = 0;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            sumFromStart += nums[i];
            sumFromEnd += nums[j];
            maxSumFromStart[i] = sumFromStart;
            maxSumFromEnd[j] = sumFromEnd;
        }
        
        int count = 0;
        
        for(int i = 0; i < len-1 ;i++){
            if(maxSumFromStart[i]>= maxSumFromEnd[i+1]){
                count++;
            }
        }
        return count;
    }
    
    
    // long[] helper1(int[] nums, int len ){
    //     long[] maxSumFromStart = new long[len];
    //     long sum =0;
    //     for(int i =0; i<len; i++){
    //         sum = sum + nums[i];
    //         maxSumFromStart[i] = sum; 
    //     }
    //     return maxSumFromStart;
    // }
    // long[] helper2(int[] nums, int len ){
    //     long[] maxSumFromEnd = new long[len];
    //     long sum =0;
    //     for(int i =len - 1; i>=0; i--){
    //         sum = sum + nums[i];
    //         maxSumFromEnd[i] = sum; 
    //     }
    //     return maxSumFromEnd;
    // }
    
}
//3 -1 =2
//sum of 10 
    //10, 14,  6, 13
   // 13,  3, -1,  7
    
    
    