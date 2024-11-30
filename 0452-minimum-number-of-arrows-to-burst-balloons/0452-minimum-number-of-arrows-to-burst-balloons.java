class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        int intervalEnd = points[0][1];
        int count = points.length;;
        for(int i=1; i<points.length;i++) {
            if(points[i][0] <= intervalEnd) {
                count--;
            }else {
                intervalEnd = points[i][1];
            }
        }
        return count;
    }
}