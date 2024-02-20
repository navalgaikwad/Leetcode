class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target);
    }
    int helper(int[] nums, int target) {
        int left =0;
        int right =nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            //[4,5,6,7,0,1,2] 0
            //start < target
            if(nums[left]<= nums[mid]) {
                if(nums[left]<=target && nums[mid]>target) {
                    right = mid - 1;
                }else {
                    left = mid +1;
                }
            }else {
                if(nums[right]>=nums[mid]) {
                    if(nums[right]>=target && nums[mid] < target) {
                        left = mid+1;
                    }else {
                        right = mid -1;
                    }
                }
            }
        }
        return -1;
    }
}