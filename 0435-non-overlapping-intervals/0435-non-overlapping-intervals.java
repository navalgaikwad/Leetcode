class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0] - b[0]);
        int endTime = intervals[0][1];
        int len = intervals.length;
        int count =0;
        for(int i=1; i<len; i++) {
            if(intervals[i][0] < endTime) {
                count++;
                endTime = Math.min(intervals[i][1], endTime);
            }else {
                endTime = intervals[i][1];//update
            }
        }
        return count;
    }
}