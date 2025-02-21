class Solution {
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
         if(nums.length > 1) {
       helper(nums, 0, nums.length-1);
       helper(nums, 0, k-1);
       helper(nums, k , nums.length-1);
         }
        
    }

    void helper(int[] nums, int start, int end) {
        for(int i= start; i<=end; i++) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }
}