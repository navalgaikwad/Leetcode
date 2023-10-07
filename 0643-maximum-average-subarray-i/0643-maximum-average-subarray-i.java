class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k; i++){
            sum=sum+nums[i];
        }
        int max=Integer.MIN_VALUE;
        double res=sum;
        for(int i=k; i<nums.length; i++){
            sum=sum+nums[i]-nums[i-k];
            res= Math.max(res, sum);
        }
        
        return res/k;
    }
}

  // for(int i=k;i<nums.length;i++){
  //           sum+=nums[i]-nums[i-k];
  //               res=Math.max(res,sum);
  //       }
  //       return res/k;