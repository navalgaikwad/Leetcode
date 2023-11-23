class Solution {
    public int missingNumber(int[] nums) {
        int sum =0;
        for(int num: nums){
            sum=sum + num;
        }
        int n = nums.length;
        n = n*(n+1)/2;
        
        return  n - sum ;
    }
}