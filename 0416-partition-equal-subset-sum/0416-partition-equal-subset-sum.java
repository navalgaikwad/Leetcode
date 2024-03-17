class Solution {
      public boolean canPartition(int[] nums) {
          int sum = Arrays.stream(nums).sum();
          if(sum%2 != 0) {
              return false;
          }
          sum /= 2;
          boolean[] dp = new boolean[sum + 1];
          dp[0] = true;
          for(int i=0; i<nums.length; i++) {
              for(int j = sum; j>=nums[i]; j--) {
                  boolean notTake = dp[j - nums[i]];
                  boolean take = dp[j];
                  
                  dp[j] =  take || notTake; 
              }
          }
          return dp[sum];
    }
    //find total sum
    // if not even return false
    //define dp of sum+1 of boolean type
    //for from i to nums.lenght
    //for from sum to nums[i] j--

    // static boolean tabulation(int target, int[] num) {
    //     boolean[] table = new boolean[target + 1];
    //     table[0] = true;
    //     for (int i = 0; i < target; i++) {  // Fix: Change i <= target to i < target
    //         if (table[i]) {
    //             for (int nu : num) {
    //                 if (i + nu <= target) {
    //                     table[i + nu] = true;
    //                 }
    //             }
    //         }
    //     }
    //     return table[target];
    // }
}