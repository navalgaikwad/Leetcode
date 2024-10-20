class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        int target = sum/2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int num : nums) {
            Set<Integer> currentSum = new HashSet<>();
            for(Integer s : set) {
                if(num + s == target) {
                    return true;
                }
                if(num + s < target) {
                    currentSum.add(num+s);
                }
            }
            set.addAll(currentSum);
        }
        return false;
    }
}