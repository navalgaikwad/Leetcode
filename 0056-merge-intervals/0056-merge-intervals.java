class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merge = new LinkedList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        
        for(int[]  interval: intervals){
            if(merge.isEmpty() || merge.getLast()[1] < interval[0]){
                merge.add(interval);
            }else if(interval[0] <= merge.getLast()[1]){
                merge.getLast()[1] =  Math.max(interval[1], merge.getLast()[1]);
                //take max from intervals
            }
        }
        
        int[][] arr = new int[merge.size()][2];
        int i = 0;
        for (int[] interval : merge){
            arr[i] = interval;
            i += 1;
        }
        
        return arr;
    }
}

//[[1,4],[3,5]]
//[1, 5] end < satrt