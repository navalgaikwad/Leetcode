class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }
    
   void helper(int[] candidates, int target, int sum, int index, List<Integer> runningList, List<List<Integer>> result){
        if(index == candidates.length){
            if(sum == target){
               result.add(new ArrayList<>(runningList)); 
            }
         return;
        }
        int sum1 = sum+candidates[index];
        if(sum1<=target){
            runningList.add(candidates[index]);
            helper(candidates, target, sum1, index, runningList, result);
            runningList.remove(runningList.size()-1);
        }
        helper(candidates, target, sum, index+1, runningList, result);    
        
         
    }
}