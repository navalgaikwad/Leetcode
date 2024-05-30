class Solution {

    
   Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // Sort the array to handle duplicates
        dfsSum(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }

    void dfsSum(int[] candidates, int target, int sum, ArrayList<Integer> runningList, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(runningList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                // Skip duplicates
                continue;
            }
            if (sum <= target) {
                runningList.add(candidates[i]);
                dfsSum(candidates, target, sum + candidates[i], runningList, i + 1); 
                runningList.remove(runningList.size() - 1);
            }
        }
    }
}