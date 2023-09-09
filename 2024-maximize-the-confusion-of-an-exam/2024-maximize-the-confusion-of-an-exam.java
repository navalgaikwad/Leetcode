class Solution {
    public int maxConsecutiveAnswers(String num, int k) {
       int noTrue=0;
        int left=0;
        int max=0;
       char[] nums = num.toCharArray();
        for(int r=0; r<nums.length; r++){
            if(nums[r]=='T'){
                noTrue++;
            }
            while(noTrue>k){
                if(nums[left]=='T'){
                  noTrue--;  
                }
                left++;
            }
            max=Math.max(max, r-left+1);
            
        }
         int noFalse=0;
         left=0;
         for(int r=0; r<nums.length; r++){
            if(nums[r]=='F'){
                noFalse++;
            }
            while(noFalse>k){
                if(nums[left]=='F'){
                  noFalse--;  
                }
                left++;
            }
            max=Math.max(max, r-left+1);
            
        }
        return max;
    }
}

