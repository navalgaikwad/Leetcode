import java.util.*;

public class Solution {
    class TaskInfo {
        public int count;
        public int availableTime;
        
        public TaskInfo(int count, int availableTime) {
            this.count = count;
            this.availableTime = availableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : taskCount) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }
        
        LinkedList<TaskInfo> cooldownQueue = new LinkedList<>();
        int time = 0;
        
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            if (!maxHeap.isEmpty()) {// max heap operation
                int currentCount = maxHeap.poll();
                if (currentCount > 1) {
                    //remove from maxHeap add to the queue with available time
                    cooldownQueue.addFirst(new TaskInfo(currentCount - 1, time + n + 1));
                }
            }
            time++;
            //cooldownQueue.getLast().availableTime <= currenttime 
            //this activate when last elemnt in queue  availableTime is less than time
            //cool down operation
            while (!cooldownQueue.isEmpty() && cooldownQueue.getLast().availableTime <= time) {
                TaskInfo task = cooldownQueue.removeLast(); //from from last 
                maxHeap.add(task.count);//add to max time
            }
        }
        
        return time;
    }
}

// find count put count in the maxheap
// take first put in the cooldown heap with reducing count and next avaiable time
// untill increase the time
// when next elemnt is availble remove elemnt from last put back in the maxheap