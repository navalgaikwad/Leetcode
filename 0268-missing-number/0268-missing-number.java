class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length + 1;
        int[] no = new int[len];
        int i=0;
        for(int num: nums){
            no[num]++;
        }
       for(int n =0; n<len; n++){
        if(no[n]==0){
            return n;
        }
       }
        
        return 0;
    }
}