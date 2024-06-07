class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        
        int endTime = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < endTime) {
                count++;
                endTime = Math.min(endTime, intervals[i][1]);
            }else {
                endTime = intervals[i][1];
            }
        }
        
        return count;
    }
}