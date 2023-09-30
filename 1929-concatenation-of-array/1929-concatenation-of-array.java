class Solution {
    public int[] getConcatenation(int[] nums) {
       int j=0;
       int[] ans=new int[2*nums.length];
       for(int i=0; i<2*nums.length; i++){
           ans[i] =nums[j++];
           if(j == nums.length){
               j=0;
           }
           
       }
     return ans;
    }
}