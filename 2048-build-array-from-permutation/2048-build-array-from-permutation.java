class Solution {
    public int[] buildArray(int[] nums) {
        int[] res=new int[nums.length];
        int temp;
        for(int i=0;i<nums.length;i++){
            res[i]=nums[nums[i]];;
        }
        return res;
    }
}