class Solution {
    public boolean canJump(int[] nums) {
        //nums = [3,2,1,0,4]
        //[2,3,1,1,4]
        // 2,3,1,1, 4
        //
//         int len = nums.length-1; 
//         if(len<=0){
//             return true;
//         }
//         int prev =nums[0];
        
//         int j=0;
//         for(int i=1; i< nums.length ; i++){
//             if(nums[i]> prev && prev>=i){
//               prev = nums[i];//3
//               if(prev == len - i){
//                   return true;
//               }
//             }
//         }
//        return false;
         int reachable = 0; //3
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;
           reachable = Math.max(reachable, i + nums[i]);
       } 
       return true;
        
        
    }
}