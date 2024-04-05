class Solution {
    public int findPairs(int[] nums, int k) {
        int i =0;
        int j = 1;
        int count = 0;
        int sum = Integer.MIN_VALUE;
        Arrays.sort(nums);
        while(i < nums.length && j < nums.length) {
            while(nums[j] - nums[i] == k && nums[i] + nums[j] != sum) {
                sum =nums[i] + nums[j];
                count++;
            }
            if(nums[j] - nums[i] < k ) {
                j++;
            }else {
                i++;
            }
            if(i == j) {
                j++;
            }
        }
        return count;
    }
}