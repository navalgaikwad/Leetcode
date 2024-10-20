class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(helper(piles, mid) <= h) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    int helper(int[] piles, int mid) {
        int sum =0;
        int count =0;
        for(int pile : piles) {
           count += Math.ceil((double) pile / mid);
        }
        return count;
    }
}