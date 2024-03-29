class Solution {
    public int findPairs(int[] nums, int k) {
        int i = 0;
        int j = 1;
        int count = 0;
        int sum = Integer.MIN_VALUE;
        Arrays.sort(nums);
        while(i < nums.length && j < nums.length) {
            if(Math.abs(nums[i] - nums[j]) == k && nums[i] + nums[j] != sum) {
                sum = nums[i] + nums[j];
                count++;
                i++;
                j++;
            }
            else if(nums[j] - nums[i] < k) {
                j++;
            }else {
                i++;
            }
             if (i == j) {
                j++;
            }
        }
        return count;
    }
}
//sort
//two pointer one i =0 j=1
//sum = for duplicate pair
