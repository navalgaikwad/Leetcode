class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> availableServer = new PriorityQueue<>((a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> unAvailableServer = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        
        for(int i=0; i<servers.length; i++) {
            availableServer.add(new int[]{servers[i], i});
        }
        int index =0;
        int time =0;
        int[] result = new int[tasks.length];
        for(int i=0; i<tasks.length; i++) {
            time = Math.max(time, i);
            if(availableServer.isEmpty()) {
                time = unAvailableServer.peek()[0];
            }
            while(!unAvailableServer.isEmpty() && unAvailableServer.peek()[0] == time) {
                int[] temp = unAvailableServer.remove();
                availableServer.add(new int[]{temp[1], temp[2]});
            }
            int[] currentServer = availableServer.remove();
            result[index++] = currentServer[1];
            unAvailableServer.add(new int[]{time + tasks[i], currentServer[0], currentServer[1]});
        }
        
        return result;
    }
}