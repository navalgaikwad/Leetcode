class Solution {
public int minGroups(int[][] intervals) {
Arrays.sort(intervals, (a, b) -> {
if (a[0] == b[0])
return a[1] - b[1];
else
return a[0] - b[0];
});
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int i = 0; i < intervals.length; i++) {
if (pq.size() > 0 && pq.peek() < intervals[i][0])
pq.remove();
pq.add(intervals[i][1]);
}
return pq.size();
}
}