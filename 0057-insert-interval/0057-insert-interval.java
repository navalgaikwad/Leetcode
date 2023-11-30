class Solution {
    private boolean overlap(int[] a, int[] b){
        return a[0] <= b[1] && b[0] <= a[1];
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
         int[][] result = new int[1][2];
        if(intervals.length==0){
            result[0] = newInterval;
            return result;
        }
        LinkedList<int[]> mergedList = new LinkedList<>();
        boolean overlapping = false;
        for(int[] interval : intervals){
            mergedList.add(interval);
            if(overlap(interval, newInterval)){
                mergedList.getLast()[1] = Math.max(newInterval[1], mergedList.getLast()[1]);
                mergedList.getLast()[0] = Math.min(newInterval[0], mergedList.getLast()[0]);
                overlapping = true;
            }
        }
        
        if(!overlapping){
            mergedList.addLast(newInterval);
        }
       
        int i = 0;
        result = new int[mergedList.size()][2];
        for (int[] interval : mergedList){
            result[i] = interval;
            i += 1;
        }
        return mergeTheInterval(result);
    }
    
    int[][] mergeTheInterval(int[][] intervals) {
        LinkedList<int[]> mergedList = new LinkedList<>();
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        for(int[] interval :intervals) {
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