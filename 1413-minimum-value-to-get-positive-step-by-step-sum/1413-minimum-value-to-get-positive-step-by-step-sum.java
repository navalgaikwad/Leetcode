class Solution {
    public int minStartValue(int[] nums) {
        int minCumulativeSum = 0;
        int cumulativeSum = 0;

        for (int num : nums) {
            cumulativeSum += num;
            minCumulativeSum = Math.min(minCumulativeSum, cumulativeSum);
        }

        return 1 - minCumulativeSum;//-4
    }
}

//-3,2,-3,4,2
//-3,-1,-4,0,2 pref
// 2,5,3,6,2 su

//1,-1,-4
