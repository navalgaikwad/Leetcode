class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majaority = nums[0];
        for(int i =0; i< nums.length; i++){
            if(majaority==nums[i]){
                count++;
            }else{
                count--;
            }
            
            if(count <= 0){
                count = 1;
                majaority = nums[i];
            }
        }
        return majaority;
    }
}