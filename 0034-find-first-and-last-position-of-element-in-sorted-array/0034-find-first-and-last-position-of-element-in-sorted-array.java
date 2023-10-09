class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int n = nums.length;
        
        for (int i = 0; i < n; i++){
            while(i < n && nums[i] == target){
                if (result[0] == -1){
                    result[0] = i;
                }
                result[1] = i;
                i += 1;
            }
            
            if (result[0] != -1 && result[1] != -1){
                return result;
            }
            
        }
        
        return result;
    }
}