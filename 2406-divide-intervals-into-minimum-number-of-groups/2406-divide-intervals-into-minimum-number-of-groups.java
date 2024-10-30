class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int[] interval :intervals) {
            if(!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.remove();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}