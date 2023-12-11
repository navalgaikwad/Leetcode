class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];

        // Calculate prefix sum
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        //10  14  6  13
        for(long suffix: prefixSum) {
            System.out.print(suffix +"  ");
        }
        
        // Calculate suffix sum 
        //13  3  -1  7  
        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        for(long suffix: suffixSum) {
            System.out.print(suffix +"  ");
        }
        // Count valid splits
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefixSum[i] >= suffixSum[i + 1]) {
                count++;
            }
        }

        return count;
    }
}