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
//1^1 =0 
//2^2 =0
//missing no : m^i^num
//3^0^3^1^0^2^1
//0^2
//2