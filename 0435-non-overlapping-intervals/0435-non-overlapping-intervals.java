class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) ->a[0] - b[0]);
        int[] interval = intervals[0];
        int endTime = interval[1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < endTime) {
                count++;
                endTime = Math.min(endTime, intervals[i][1]);
            }else {
                //non overlapping
                endTime = intervals[i][1];
            }
        }
        return count;
    }
}

//[[1,2], [1,3],[2,3],[3,4],]
//
//