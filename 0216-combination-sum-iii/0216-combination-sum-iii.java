class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> path = new ArrayList<>();
        helper(nums, n, 0, path, res, k);
        return res;
    }
    private void helper(int[] nums, int target, int startIndex, List<Integer> path, List<List<Integer>> res, int k) {
        if (path.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // if (nums[i] > target) {
            //     return;
            // }
            path.add(nums[i]);
            helper(nums, target - nums[i], i + 1, path, res, k);
            path.remove(path.size() - 1);
        }
    }
}
