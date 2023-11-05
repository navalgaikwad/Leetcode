class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        helper(nums, ans, 0);
        return result;
    }
    
    void helper(int[] nums, List<Integer> ans, int curr){
        result.add(new ArrayList<>(ans));
        for(int i = curr; i < nums.length; i++){
            
            ans.add(nums[i]);
            helper(nums, ans, i + 1);
            ans.remove(ans.size() - 1);
            
        }
    }
}