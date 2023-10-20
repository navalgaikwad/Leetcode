class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
     List<int[]> left = new ArrayList<>();
     List<int[]> right = new ArrayList<>();
        int s = newInterval[0];
        int e = newInterval[1];
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]  [4,8]
        
        for(int[] interval :intervals){
             if( interval[1] < newInterval[0]){ // 2<4
             left.add(interval);
         }
        }
        
     for(int[] interval :intervals){
            if(interval[0] > newInterval[1]){
             right.add(interval);
         } 
       }
        int leftLength =left.size();
        int rightLength = right.size();
        if( leftLength + rightLength != intervals.length){
             s = Math.min(s, intervals[leftLength][0]);
             e = Math.max(e, intervals[(intervals.length -1) - rightLength][1]);
         
        }
        //  s = min(s, intervals[len(left)].start)
        // e = max(e, intervals[~len(right)].end)
        
        List<int[]> result = new ArrayList<>();
        result.addAll(left);
        int[] mergedInterval = new int[2];
        mergedInterval[0] = s;
        mergedInterval[1] = e;
        result.add(mergedInterval);
        result.addAll(right);
        
        return result.toArray(new int[ result.size() ][ ]);
      //  return Arrays.toArray;
        
    }
}