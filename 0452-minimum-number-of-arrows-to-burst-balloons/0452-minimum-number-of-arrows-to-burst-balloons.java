class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points, (a, b)->Integer.compare(a[1], b[1]));
        int[] prev = points[0];
        int count =points.length;
        for(int i =1; i<points.length; i++) {
            int[] intervals = points[i];
            if(intervals[0]<=prev[1]) {
                count--;
            }else {
                prev = intervals;
            }
        }
        return count;
    }
}
//sort start time
//check if it is falling inside codition
//if not change interval
//10,16
