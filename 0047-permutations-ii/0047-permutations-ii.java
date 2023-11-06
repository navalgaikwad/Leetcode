class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        helper(ans, nums, 0);
        return new ArrayList<>(set);
    }
    
    void helper(ArrayList<Integer> ans, int[] nums, int index){
        if(index == nums.length){
           System.out.println(Arrays.toString(nums));
            set.add(arrayToList(nums)); 
            return;
        }
        
        for(int i = index; i<nums.length; i++){
            swap(nums, index, i);
            helper(ans, nums, index + 1);
            swap(nums, index, i);
        }
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
     private List<Integer> arrayToList(int[] nums) {
        return IntStream.of(nums).boxed().collect(Collectors.toList());
        }
}