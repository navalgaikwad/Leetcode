class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left =0;
        int product =1;
        int len = 0;
        if(k<=1) return 0;
       // Map<Integer, Inetegr> map = new HashMap<>();
        for(int right =0; right < nums.length; right++) {
            product *= nums[right];
            while(product >=k && left < nums.length) {
                product/=nums[left];
                left++;
            }
            len +=right - left + 1;
        }
        
        return len < 0? 0 : len;
    }
}