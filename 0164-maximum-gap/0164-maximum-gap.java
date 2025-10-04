class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        count[0] = 0;
        for(int i=1; i<nums.length; i++) {
            count[i] = nums[i] - nums[i-1];
        }
        return Arrays.stream(count).max().getAsInt();
        //return 0;
    }
}