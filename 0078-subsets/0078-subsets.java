class Solution {
    Set<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
         answer = new HashSet<>();
        helper(0, nums, new ArrayList<>());
        return new ArrayList<>(answer);
    }
    
    void helper(int curr, int[] nums, List<Integer> result){
       
      answer.add(new ArrayList<>(result));
      for(int i=curr; i<nums.length; i++){
        result.add(nums[i]);  
        helper(i+1, nums, result);
        result.remove(result.size()-1);
      }
    }
}
