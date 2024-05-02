class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        Set<Integer> set = new HashSet<>();
        int sum =0;
        int max =0;
        for(int right = 0; right < nums.length; right++) {
            while(!set.add(nums[right])) {
                sum -=nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum +=nums[right];
            max = Math.max(max, sum);
                
        }
        return max;
    }
}
