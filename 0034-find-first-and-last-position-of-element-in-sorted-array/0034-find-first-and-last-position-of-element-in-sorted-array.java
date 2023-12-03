class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition =  binarySearchFirst(nums, target);
        int lastPosition  =   binarySearchLast(nums, target);
        //System.out.print(firstPosition);
     
        return new int[]{firstPosition, lastPosition};
    }
    
    int binarySearchLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target) {
                position = mid;
            }
            
            if(nums[mid] <= target) {
                //position = mid;
                left = mid + 1;
                
            }else {
                right = mid - 1;
            }
        }
        return position;
    }
    
     int binarySearchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target) {
                position = mid;
            }
            
            if(nums[mid] >= target) {
                right = mid - 1;
            }else {
                //position = mid;
                left = mid + 1;
            }
        }
        return position;
    }
}