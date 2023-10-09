class Solution {
    public int[] searchRange(int[] nums, int t) {
        int[] result = new int[]{-1, -1};
        int n = nums.length;
        
        for (int i = 0; i < n; i++){
           while(i < n && nums[i] == t){
               if(result[0]==-1 && nums[i] == t){
                 result[0]=i;  
               }
               {
                  result[1]=i;    
               }
               i++;
           }
            if(result[0]!=-1 && result[1]!=-1){
                return result;
            }
            
        }
        
        return result;
    }
}