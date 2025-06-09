class Solution {
    public int[][] merge(int[][] intervals) {
        // List<int[]> allIntervals = new ArrayList<>();

        // // Add all intervals from both arrays
        // Collections.addAll(allIntervals, interval1);
        // Collections.addAll(allIntervals, interval2);

//  int totalLength = intervals1.length + intervals2.length;
//         int[][] intervals = new int[totalLength][2];
//         int index = 0;
//         for (int[] interval : intervals1) {
//             intervals[index++] = interval;
//         }
//         for (int[] interval : intervals2) {
//             intervals[index++] = interval;
//         }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            if (!list.isEmpty() && list.getLast()[1] >= interval[0]) {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            } else {
                list.addLast(interval);
            }
        }
        int[][] result = new int[list.size()][2];
        int i = 0;
        for (int[] interval : list) {
            result[i] = interval;
            i += 1;
        }

        return result;
    }
}