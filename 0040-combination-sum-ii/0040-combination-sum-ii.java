class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        helper(candidates, target, 0 , 0, new ArrayList<>());
        return result;
    }
    void helper(int[] candidates, int target, int index, int sum, List<Integer> running) {
        
        if(sum == target) {
            result.add(new ArrayList<>(running));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(sum <= target) {
                running.add(candidates[i]);
                helper(candidates, target, i + 1, candidates[i] + sum, running);
                running.remove(running.size()-1);
            }
        }
    }
}/*
Time Complexity: 
\U0001d442
(
2
\U0001d441
⋅
\U0001d441
)
O(2 
N
 ⋅N)

Space Complexity: 
\U0001d442
(
\U0001d441
)
O(N) (excluding output).


*/