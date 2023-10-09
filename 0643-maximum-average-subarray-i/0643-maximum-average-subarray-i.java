class Solution {
    public double findMaxAverage(int[] nums, int k) {
       // int i=0; 
    
       double sum = 0;
       
       for(int i=0; i<k; i++){
           sum=sum+nums[i];
       }
         double max=sum;
       for(int i=k; i<nums.length; i++){
           sum=sum+nums[i]-nums[i-k];
           max = Math.max(max, sum);
       }
        return max/k;
    }
}