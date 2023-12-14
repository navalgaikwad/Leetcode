class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int ans =0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(check(nums,k, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
        
    }
    
    boolean check(int[] nums, int k, int mid) {
        int sum = 0;
        int count = 1;
        for(int i =0 ;i<nums.length; i++) {
            sum=sum+nums[i];
            if(sum > mid) {
                count++;
                sum = nums[i];//create partion
            }
        }
        return count<=k;
    }
}

//[7,2,5,10,8] 5-2 = 3
//[2,5,7,8,10] k = 2
//[2,7,14,22,32] k = 2
//14-2+2
//32-22+8=10+8=18
//binary search