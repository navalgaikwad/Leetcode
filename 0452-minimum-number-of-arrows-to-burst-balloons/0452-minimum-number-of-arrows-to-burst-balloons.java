class Solution {
    public int findMinArrowShots(int[][] intervals) {
        int count = intervals.length;
        //[[1,2],[2,3],[3,4],[4,5]]
        Arrays.sort(intervals, (a, b) ->Integer.compare(a[1], b[1]));
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if( interval[0] <= prev[1] ){
               count--;
            }else{
               prev = interval; 
            }
        }
        return count;
    }
}