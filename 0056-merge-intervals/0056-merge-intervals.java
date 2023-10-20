class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merger = new LinkedList<>();
        Arrays.sort(intervals, (a,b) ->Integer.compare(a[0], b[0]));
        for(int[] interval: intervals){
            if(merger.isEmpty() || merger.getLast()[1]<interval[0]){
                merger.addLast(interval);
            }else{
               // if(merger.getLast()[1] > interval[0]){
                    int max = Math.max(merger.getLast()[1], interval[1]);
                   merger.getLast()[1]=max;
               // }
                
            }
        }
        return merger.toArray(new int[merger.size()][]);
        
    }
}