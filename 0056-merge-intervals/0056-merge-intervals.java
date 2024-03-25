class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merger = new LinkedList<>();
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        merger.add(intervals[0]);
        for(int i =0; i<intervals.length; i++) {
            if(!merger.isEmpty()&&intervals[i][0] <= merger.getLast()[1]) {
                merger.getLast()[1] = Math.max(intervals[i][1], merger.getLast()[1]);
            }else {
                merger.addLast(intervals[i]);
            }
        }
         return merger.toArray(new int[merger.size()][]);
    }
}

/*
there will be negative no
they will be sorted
1 size input
2 size i

*/