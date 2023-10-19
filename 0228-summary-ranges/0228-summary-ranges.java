class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if (nums.length == 0){
            return ans;
        }

        int end = 0;
        int start =0;
        
        for(int i=1; i < nums.length; i++){
            if(nums[i] - nums[end] != 1){
                ans.add(buildString( start, end, nums));
                start = i;
            }
            end = i;
        }
        
         ans.add(buildString( start, end, nums));
        
        return ans;
    }
    
    private static String buildString(int start, int end, int[] nums){
         if (start == end){
                    return "" + nums[start];
                }
                    return nums[start] +"->"+ nums[end];
    }
}