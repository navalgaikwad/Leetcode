class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length/2; 
        int count =0;
        int pre = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=pre){
                count =0;
                pre = nums[i];
                count++;
            }else{
                count++;
                if(count>size){
                    return nums[i];
                }
            }
        }
        return 0;
    }
}