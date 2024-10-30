import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> mergedList = new ArrayList<>();
        //1. if it is at first return range
        //2. no overlapping
        //3. update the newIntegervals
        for(int i=0; i<intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]) {
                mergedList.add(newInterval);
                Collections.addAll(mergedList, Arrays.copyOfRange(intervals, i, intervals.length));
                return mergedList.toArray(new int[mergedList.size()][]); 
            }else if(intervals[i][1] < newInterval[0]) {
                mergedList.add(intervals[i]);
            }else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        mergedList.add(newInterval);
        return mergedList.toArray(new int[mergedList.size()][]);  
    }
}
/*
[[2,5],[6,9]], newInterval = [1,3]



*/
// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         for(int[] interval : intervals) {
//             if(newInterval[0] < interval[1]) {
//                 interval[1] = Math.max(interval[1], newInterval[0]);
//                 interval[0] = Math.min(interval[0], newInterval[0]);
//             }
//         }
//         return intervals;
//     }
// }

// intervals = [[1,3],[6,9]], newInterval = [4,5]
//[1, ]
//2<3 merge start2 < end1
//4<3 not merge 

//intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//[1,2]
