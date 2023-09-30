class Solution {
    public int[] getConcatenation(int[] nums) {
//        int j=0;
//        int[] ans=new int[2*nums.length];
//        for(int i=0; i<2*nums.length; i++){
//            ans[i] =nums[j++];
//            if(j == nums.length){
//                j=0;
//            }
           
//        }
//      return ans;
         int len = nums.length;
        int[] ans = new int[2*len];
        for(int i = 0; i < len; i++){
            ans[i] = nums[i];
            ans[i+len] = nums[i];
        }
        System.gc();
        return ans;
    }
}