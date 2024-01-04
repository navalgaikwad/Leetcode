class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
      List<Integer> ans = new ArrayList<>();
      backTracking(ans, nums);
      return result;
        
    }
    
   void backTracking(List<Integer> ans, int[] nums){
        if(ans.size() == nums.length){
           result.add(new ArrayList<>(ans));
           return;
        }
       
       for(int num: nums){
           if(!ans.contains(num)){
              ans.add(num);
              //System.out.print(ans);
              backTracking(ans, nums);
              ans.remove(ans.size() - 1 );
           }
       }
    }
}