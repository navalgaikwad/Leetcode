class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    void helper(int[] nums, int index, List<Integer> runningList) {
        result.add(new ArrayList<>(runningList));
        for(int i=index; i<nums.length; i++) {
            runningList.add(nums[i]);
            helper(nums, i + 1, runningList);
            runningList.remove(runningList.size()-1);
        }
    }
}