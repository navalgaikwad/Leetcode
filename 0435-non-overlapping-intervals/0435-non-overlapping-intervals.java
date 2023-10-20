class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;
        //1, 2 //2,3 //3,4  1,3
       // [[1,2],[1,2],[1,2]]
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prevEnd = intervals[0][1];
        
        for(int i=1 ;i<intervals.length; i++){
           int[] current = intervals[i];
           if(current[0] < prevEnd){
               count ++;
               prevEnd = Math.min(prevEnd, current[1]);
           }else{
                prevEnd =  current[1]; 
           }
        } 
          return count;
        }
}