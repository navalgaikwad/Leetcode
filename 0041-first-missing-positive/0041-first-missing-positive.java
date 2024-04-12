class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if( nums[i] <0 || nums[i] > nums.length) {
                //return false;
                continue;
            }
            set.add(nums[i]);
        }
        //System.out.print(set);
        
        for(int i=1; i<=nums.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
}