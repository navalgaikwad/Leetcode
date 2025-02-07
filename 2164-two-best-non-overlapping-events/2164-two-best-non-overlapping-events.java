class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b)->Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[0] - b[0]);
        int max = 0;
        int ans =0;
        for(int i=0; i<events.length; i++) {
            while(!pq.isEmpty() && pq.peek()[0] < events[i][0]) {
                max = Math.max(max, pq.poll()[1]);
            }
            ans = Math.max(ans, max + events[i][2]);
            pq.add(new int[]{events[i][1], events[i][2]});
        }
        return ans;
    }
}