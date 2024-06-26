class Solution {
    public int[] searchRange(int[] nums, int target) {
         int start = firstPosition(nums, target, 0, nums.length - 1);
         int end = LastPosition(nums, target, 0, nums.length - 1);
       // System.out.print(end);
        return new int[]{end, start};
    }
    
    int firstPosition(int[] nums, int target, int start, int end) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                ans = mid;
            }
            if(nums[mid] <= target) {
               // ans = start;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
    
     int LastPosition(int[] nums, int target, int start, int end) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                ans = mid;
            }
            if(nums[mid] >= target) {
                //ans = start;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }
}