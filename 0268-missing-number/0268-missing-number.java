class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >=0 && nums[i] < nums.length) {
                set.add(nums[i]);
            }
        }
        for(int i=0; i<nums.length; i++) {
            if( !set.contains(i) ) {
                return i;
            }
        }
        return nums.length;
    }
}