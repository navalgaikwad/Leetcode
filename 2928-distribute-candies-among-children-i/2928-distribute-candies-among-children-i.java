class Solution {
    
    int helper(int totalCandies, int limit, int children) {
        if(totalCandies == 0) {
            return 1;
        }
        if( children == 0) {
            return 0;
        }
        int ways =0;
        for(int i =0; i<=Math.min(limit, totalCandies); i++) {
            ways += helper(totalCandies - i, limit, children - 1);
        }
        return ways;
    }
    
    
    public int distributeCandies(int n, int limit) {
        return helper(n, limit, 3);
    }
}