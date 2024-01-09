class Solution {
    public int findMinArrowShots(int[][] points) {
        int count = points.length;
        Arrays.sort(points, (a, b)->Integer.compare(a[1], b[1]));
        int[] prev = points[0];
        for( int i=1; i < points.length; i++ ) {
            int[] intervals = points[i];
            if(intervals[0] <= prev[1]) {
                count--;
            }else {
                prev = intervals;
            }
        }
        return count;
    }
}