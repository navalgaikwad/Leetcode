class Solution {
public int[] assignTasks(int[] servers, int[] tasks) {
int[] result = new int[tasks.length];
PriorityQueue<int[]> availableServer = new PriorityQueue<>((a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
PriorityQueue<int[]> unavailableServer = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
int j =0;
for(int server : servers) {
availableServer.add(new int[]{server, j++});
}
int time =0;
//i =0;
for(int i=0; i<tasks.length; i++) {
time = Math.max(time, i);
if(availableServer.isEmpty()) {
time = unavailableServer.peek()[0];
}
while(!unavailableServer.isEmpty() && unavailableServer.peek()[0] == time) {
int[] temp = unavailableServer.remove();
availableServer.add(new int[]{temp[1], temp[2]});
}
int[] available = availableServer.remove();
result[i] = available[1];
unavailableServer.add(new int[]{time + tasks[i], available[0], available[1]});