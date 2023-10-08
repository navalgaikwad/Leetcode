class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int j=0;
        int max=0;
        int product=1;
        if(k<=1){
            return 0;
        }
        for(int i=0; i<nums.length; i++){
            product=product*nums[i];
            while(product>=k){
               product= product/nums[j];
               j++;
            }
            max=max+ i-j+1;
        }
        
        return max;
    }
}