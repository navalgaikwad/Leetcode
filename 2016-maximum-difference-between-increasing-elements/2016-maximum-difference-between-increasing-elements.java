class Solution {
    public int maximumDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num - min);
        }
        return max == 0 ? -1 : max;
    }
}