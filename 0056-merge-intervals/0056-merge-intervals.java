class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> mergedList = new LinkedList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        
        for(int[]  interval: intervals){
            if(mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]){
                mergedList.add(interval);
            }else if(interval[0] <= mergedList.getLast()[1]){
                mergedList.getLast()[1] =  Math.max(interval[1], mergedList.getLast()[1]);
                //take max from intervals
            }
        }
        
        int[][] result = new int[mergedList.size()][2];
        int i = 0;
        for (int[] interval : mergedList){
            result[i] = interval;
            i += 1;
        }
        
        return result;
    }
}

//[[1,4],[3,5]]
//[1, 5] end < satrt


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

// // intervals = [[1,3],[6,9]], newInterval = [4,5]
// //[1, ]
// //2<3 merge start2 < end1
// //4<3 not merge 

// //intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// //[1,2]