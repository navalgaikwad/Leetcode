class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;
        int min = Integer.MIN_VALUE;
       boolean flag =false;
        
       Arrays.sort(intervals, (a, b) ->Integer.compare(a[1], b[1]));
        int[] prev = intervals[0];
        for(int i=1 ;i<intervals.length; i++){
           int[] current = intervals[i];
           if(current[0] >= prev[1] ){
               prev =  current; 
           }else{
             count ++;
           }
            
        } 
          return count;
        }
}