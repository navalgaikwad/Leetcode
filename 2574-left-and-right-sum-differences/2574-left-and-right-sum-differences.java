class Solution {
    public int[] leftRightDifference(int[] nums) {
        int len = nums.length;
        int[] maxSumFromStart = new int[len];
        int[] maxSumFromEnd = new int[len];
         maxSumFromStart[0] = 0;
        int ans[]=new int[len];
         int sumFromStart = 0, sumFromEnd = 0;
        for (int i = 0, j = len - 1; i < len && j>0; i++, j--) {
            sumFromStart += nums[i];
            sumFromEnd += nums[j];
            maxSumFromStart[i + 1] = sumFromStart;
            maxSumFromEnd[j-1] = sumFromEnd;
        }
        for(int i=0;i<len;i++)
            ans[i]=Math.abs(maxSumFromStart[i]-maxSumFromEnd[i]);
        return ans;
        //return new int[]{};
    }
}