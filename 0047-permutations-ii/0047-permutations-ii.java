class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        backTracking(nums, 0);
        return new ArrayList<>(set);
    }
    
    void backTracking(int[] nums, int start) {
        if(start == nums.length) {
            set.add(arrayToList(nums));
            return;
        }
        
        for(int i = start; i<nums.length; i++) {
            swap(nums, start, i);
            backTracking(nums, start + 1);
            swap(nums, start, i);
        }
    }
    
    void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
     private List<Integer> arrayToList(int[] nums) {
        return IntStream.of(nums).boxed().collect(Collectors.toList());
    }
}