class Solution {
    int helper(int n, int limit, int people) {
        if(n == 0) {
            return 1;
        }
        if( limit == 0 || people ==0) {
            return 0;
        }
        
        int way =0;
        for(int i=0; i<=Math.min(limit, n); ++i) {
            way+=helper(n - i, limit, people -1);
        }
        return way;
    }
    
    public int distributeCandies(int n, int limit) {
        return helper(n, limit, 3);
    }
}
