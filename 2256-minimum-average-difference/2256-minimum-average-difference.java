class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int  ans = -1;
        int minDiff = Integer.MAX_VALUE;

        long preSum = 0, totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        for(int i = 0; i < n; i++){
            preSum += nums[i];
            long leftAvg = preSum / (i + 1);
            long rightAvg = (totalSum - preSum);
            if(i != n - 1){
                rightAvg /= (n - i - 1);
            }

            int currDiff = (int) Math.abs(leftAvg - rightAvg);
            if(currDiff < minDiff){
                ans = i;
                minDiff = currDiff;
            }
        }

        return ans;
    }
}