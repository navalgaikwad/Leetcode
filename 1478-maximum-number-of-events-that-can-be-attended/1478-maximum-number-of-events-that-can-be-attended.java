class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b)->a[0] - b[0]);
        int time =0;
        int count =0;
        int index =0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        while(!pq.isEmpty() || index < events.length) {
            if(pq.isEmpty()) {
                time = events[index][0];
            }
            //add all the event of that day
            while(index < events.length && events[index][0]  == time) {
                pq.add(events[index][1]);//2
                index++;
            }
            //for next door
            pq.remove();
            time++;
            count++;
            while(!pq.isEmpty() && pq.peek() < time) {
                pq.remove();
            }
        }
        return count;
    }
}