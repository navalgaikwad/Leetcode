class Solution {
    public int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE;
        int sum = 0;
        int start =0;
        int end =0;
        int j =0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(sum > best) {
                best = sum;
                start = j;
                end = i;
            }
            if(sum < 0) {
                sum =0;
                j = i+1;
            }
        }
        // ArrayList<Integer> resultArray = new ArrayList<>();
        // for (int i = start; i <= end; i++) {
        //     resultArray.add(nums[i]);
        // }
        // System.out.print(resultArray);
        return best;
    }
}