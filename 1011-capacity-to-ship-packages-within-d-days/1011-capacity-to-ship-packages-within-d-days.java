class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //it is same as divide chocolate problrm
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int ans = 0;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(checkCapacity(weights, days, mid)) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    boolean checkCapacity(int[] weights, int days, int mid) {
        int capacity = 1;
        int sum =0;
        for(int weight : weights) {
            sum = sum + weight;
            if(sum > mid) {
                capacity++;
                sum = weight;
            }
        }
        return capacity<= days;
    }
}