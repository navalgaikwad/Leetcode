class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right =nums.length - 1;
        //normal binary search
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            //for finding left position first index where it contains duplicate use  nums[mid] >= target
            //last index   nums[mid] > target
            if(nums[mid] > target) {
               right = mid - 1; // use  right = mid; 
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}