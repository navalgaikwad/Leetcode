class Solution {

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] result = new int[tasks.length];

        Comparator<int[]> freeServComparator = (a, b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (a[0] - b[0]);
        Comparator<int[]> busyServComparator = Comparator.comparingInt(a -> a[0]);

        PriorityQueue<int[]> freeServQueue = new PriorityQueue<>(freeServComparator);
        PriorityQueue<int[]> busyServQueue = new PriorityQueue<>(busyServComparator);

        for (int i = 0; i < servers.length; i++) freeServQueue.add(new int[]{servers[i], i});

        int time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(i, time);
            if (freeServQueue.isEmpty()) time = busyServQueue.peek()[0];


            while (!busyServQueue.isEmpty() && time == busyServQueue.peek()[0]) {
                int[] temp = busyServQueue.poll();
                int[] freeServer = {servers[temp[1]], temp[1]};
                freeServQueue.offer(freeServer);
            }
            int[] server = freeServQueue.poll();
            result[i] = server[1];
            busyServQueue.offer(new int[]{time + tasks[i], server[1]});


        }
        return result;
    }
}