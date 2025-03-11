class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    void helper(int[] candidates, int target, int index, int sum, ArrayList<Integer> running) {
        if (sum == target) {
            result.add(new ArrayList<>(running));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum <= target) {
                running.add(candidates[i]);
                helper(candidates, target, i + 1, sum + candidates[i], running);
                running.remove(running.size() - 1);
            }
        }
    }
}