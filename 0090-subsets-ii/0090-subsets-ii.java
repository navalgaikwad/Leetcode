class Solution {
     Set<List<Integer>> result = new HashSet<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        helper(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }
    
    void helper(int[] nums, int index, ArrayList<Integer> runningList) {
        result.add(new ArrayList<>(runningList));
        for(int i= index; i<nums.length; i++) {
            // if(i > index && nums[i] == nums[i-1]) {
            //     break;
            // }
            runningList.add(nums[i]);
            helper(nums, i + 1, runningList);
            runningList.remove(runningList.size() - 1);
        }
    }
}