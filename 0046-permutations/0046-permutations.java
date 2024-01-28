class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new ArrayList<>());
        return result;
    }
    
    void backtracking(int[] nums, List<Integer> runningList) {
        if(nums.length == runningList.size()) {
            result.add(new ArrayList<>(runningList));
            return;
        }
        for(int num : nums) {
            if(!runningList.contains(num)) {
                runningList.add(num);
                backtracking(nums, runningList);
                runningList.remove(runningList.size()-1);
            }
        }
    }
}