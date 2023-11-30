class Solution {
    private boolean overlap(int[] a, int b){
        return a[0] < b; // play with endTime
    }
    //[[0,2],[1,3],[2,4],[3,5],[4,6]]
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int endTime = intervals[0][1];
        int count =0;
        for(int i = 1 ;i<intervals.length; i++){
            if(overlap(intervals[i], endTime)){ 
                count++; //if there is count++, 
                endTime = Math.min(intervals[i][1], endTime);
            }else {// if there is no overlap take next overlapp
                endTime = intervals[i][1];
            }
        }
        return count;
    }
}

//[[1,2],[2,3],[3,4],[1,3]]
//[3, 4]
// [1, 3]
//