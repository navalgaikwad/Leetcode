class Solution {
    public int findPeakElement(int[] nums) {
        
		if(nums.length == 1) return 0; // single element
        
        int n = nums.length;
        
		// check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
		
		// search in the remaining array
        int start = 1;
        int end = n-2;
        
        // int start =0;
        // int end =nums.length - 1;
       while(start <= end) {
           int mid = start + (end - start)/2;
           if(nums[mid -1] < nums[mid] && nums[mid] > nums[mid + 1]) {
               return mid;
           }
           if(nums[mid] > nums[mid + 1]) {
               end = mid - 1;     
           }else  {
               start = mid + 1;   
           }
       }
        return start;
    }
}