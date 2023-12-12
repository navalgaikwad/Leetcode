class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] prefix = new long[nums.length];
        long[] suffix = new long[nums.length];
        prefix[0] = nums[0];
        int n = nums.length;
       
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        
        int[] result = new int[n];
        for(int i = 0; i<n; i++) {
            if(i + k >= n || i-k < 0 ) {
                result[i] = -1;
            }else {
                long suff = suffix[i - k] - suffix[i];// from that element to left 
                long pref = prefix[i + k] - prefix[i];// from that elemnt to right
                long sum = suff + (long)nums[i] + pref;// do sum from left and right
                long noOfElement = (2 * k + 1);//no of elemnt
                long answer = sum/noOfElement;
                result[i] = (int)answer;
            }
        }
        return result;
    }
}

//7,4,3,9,1,8,5,2,6 k=3
//