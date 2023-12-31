class Solution {
    public int search(int[] nums, int target) {
         int result = binarySearch(nums, target);
        return result;
    }
    //11,9,8,1,2,3,4,5
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]) {// normal sorted//starting and middle
               if(nums[left] <= target && nums[mid] > target ) { // normal condition
                    right = mid - 1;
                }else {
                    left = mid + 1;
                } 
            } else {
            if(nums[right] >= nums[mid]) {// right side normal sorted last and miidle
               if(nums[right] >= target && nums[mid] < target ) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                } 
              }
            }
            
        }
        return -1;
    }
}