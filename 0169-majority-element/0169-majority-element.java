class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 1;
        for(int num : nums) {
            if(maj == num) {
                count++;
            }else {
                count--;
            }
            if(count <= 0) {
                maj = num;
                count = 1;
            }
        }
        return maj;
    }
}