class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    
    void helper(int[] candidates, int target, int index, List<Integer> runningSum, int sum) {
        if(target == sum) {
            result.add(new ArrayList<>(runningSum));
            return;
        }
        for(int i= index; i<candidates.length; i++) {
            
            if(sum <=target) {
                //sum+=candidates[i];
                runningSum.add(candidates[i]);
                helper(candidates, target, i, runningSum, sum+candidates[i]);
                runningSum.remove(runningSum.size()-1);
            }
        }
    }
}