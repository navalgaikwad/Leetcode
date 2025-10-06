class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        if(n == 0 || n < l) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++) {
            int sum = 0;
            for(int j=i; j<nums.size(); j++ ) {
                sum+=nums.get(j);
                int length = j - i + 1;
                if(length>=l && length<=r && sum >0) {
                    min = Math.min(min, sum);
                }
            }
        }
         return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}