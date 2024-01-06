class Solution {
    HashSet<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, new ArrayList<>(), 0);
       // System.out.print(result);
        return new ArrayList<>(result);
    }
    
    void backTracking(int[] nums, List<Integer> runningList, int index) {
        
        result.add(new ArrayList<>(runningList));
        for(int i=index; i<nums.length; i++) {
            runningList.add(nums[i]);
            backTracking(nums, runningList, i + 1);
            runningList.remove(runningList.size() - 1);
        }
    }
}