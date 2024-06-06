class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right =  Arrays.stream(nums).sum();
        int ans =0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int sum =0;
            int count = 1;
            for(int num : nums) {
                sum = sum + num;
                if(sum > mid) {
                    count++;
                    sum = num;
                }
            }
            if(count <= k) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
}