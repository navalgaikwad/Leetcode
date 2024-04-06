class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0] - b[0]);
        LinkedList<int[]> merge = new LinkedList<>();
        merge.add(intervals[0]);
        for(int[] interval : intervals) {
            if(merge.getLast()[1] >= interval[0]) {
                merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);
            }else {
                merge.addLast(interval);
            }
        }
        //return result.toArray(new int[result.size()][]);
        return merge.toArray(new int[merge.size()][]);
    }
}