class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        helper(nums, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }
    
    void helper(int[] nums, List<Integer> runningList, Set<List<Integer>> result) {
        
        if(nums.length == runningList.size()) {
            result.add(new ArrayList<>(runningList));
            return;
        }
        for(int num : nums) {
            if(!runningList.contains(num)) {
                runningList.add(num);
                helper(nums, runningList, result);
                runningList.remove(runningList.size()-1);
            }
        }
    }
}