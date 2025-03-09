class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new ArrayList<>());
        return result;
    }

    void helper(int[] nums, List<Integer> runningList) {
        if (nums.length == runningList.size()) {
            result.add(new ArrayList<>(runningList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!runningList.contains(nums[i])) {
                runningList.add(nums[i]);
                helper(nums, runningList);
                runningList.remove(runningList.size() - 1);
            }
        }
    }
}