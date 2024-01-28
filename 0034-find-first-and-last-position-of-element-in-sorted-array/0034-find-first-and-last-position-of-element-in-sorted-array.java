class Solution {
    public int[] searchRange(int[] nums, int target) {
        int val1 = binarySearch1(nums, target);
        int val2 = binarySearch2(nums, target);
        return new int[]{val2, val1};
    }
    
    int binarySearch1(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
         int position = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid]==target) position = mid;
            if(nums[mid] <= target) start = mid + 1;
            if(nums[mid] > target) end = mid - 1; 
        }
        return position;
    }
    int binarySearch2(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
        int position = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid]==target) position = mid;
            if(nums[mid] >= target) end = mid - 1;
            if(nums[mid] < target) start = mid + 1; 
        }
        return position;
    }
}