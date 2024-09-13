class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missRange = new ArrayList<>();
        if(nums.length == 0){
            missRange.add(Arrays.asList(lower, upper));
            return  missRange;
        } 
        if(lower < nums[0] ) {
            missRange.add(Arrays.asList(lower, nums[0]- 1));
        }
        int n = nums.length;
        for(int i = 0; i < n-1; i++) {
            if(nums[i + 1] - nums[i]>=2){
                missRange.add(Arrays.asList(nums[i] + 1, nums[i+1] - 1));
            }
        }
        
        
        if(nums[n - 1] < upper) {
            missRange.add(Arrays.asList(nums[n - 1] + 1, upper ));
        }
        return missRange;
    }
}