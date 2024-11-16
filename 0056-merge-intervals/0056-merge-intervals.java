class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        
        for(int i=0; i<intervals.length; i++) {
            if(!list.isEmpty() && intervals[i][0] <= list.getLast()[1] ) {
            
                list.getLast()[1] =  Math.max(list.getLast()[1],intervals[i][1] );
            }else {
                list.add(intervals[i]);
            }
        }
        int[][] result = new int[list.size()][2];
        int i = 0;
        for (int[] interval : list){
            result[i] = interval;
            i += 1;
        }
        
        return result;
    }
}