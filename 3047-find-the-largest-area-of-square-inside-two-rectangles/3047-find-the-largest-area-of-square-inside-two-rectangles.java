class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        
        long ans = 0;

        for (int i=0; i<bottomLeft.length; i++) {
            for (int j=i+1; j<bottomLeft.length; j++) {

                int xl = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int xh = Math.min(topRight[i][0], topRight[j][0]);

                int yl = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int yh = Math.min(topRight[i][1], topRight[j][1]);

                int xlen = Math.max(xh - xl, 0);
                int ylen = Math.max(yh - yl, 0);

                long dim = Math.min(xlen, ylen);
                ans = Math.max(ans, dim*dim);
            }
        }

        return ans;
    }
}