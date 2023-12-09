class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right =10000000;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(helper(candies, k, mid)>=k) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    long helper(int[] candies, long k, int mid) {
        long count = 0;
        for(int candie : candies) {
            count += candie/mid;
            if(count>k){
                break;
            }
        }
        return count;
    }
}