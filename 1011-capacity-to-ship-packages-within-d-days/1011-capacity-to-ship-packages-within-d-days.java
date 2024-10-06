class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int ans =0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(helper(weights, mid, days)) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1; 
            }
        }
        return ans;
    }
    
    boolean helper(int[] weights, int mid, int days) {
        int sum =0;
        int count =1;
        for(int weight : weights) {
            sum += weight;
            if(sum > mid) {
                count++;
                sum = weight;
            }
        }
        return count<=days;
    }
}