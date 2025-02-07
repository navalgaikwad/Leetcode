class Solution {
    public void rotate(int[] nums, int k) {
          k = k% nums.length;
         if(nums.length > 1) {
            swap(nums, 0, nums.length-1);
            swap(nums, 0, k-1 );
            swap(nums, k, nums.length-1);  
         }
    }
    
    void swap(int[] nums, int start, int end) {
        while(start< end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}