class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = Arrays.stream(piles).max().getAsInt();
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(helper(piles, h, mid)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    boolean helper(int[] piles, int h, int mid) {
        int sum =0;
        for(Integer plie : piles) {
            sum+= Math.ceil((double) plie / mid);;
        }
        return sum<=h;
    }
}