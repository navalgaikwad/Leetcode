class Solution {
public int maxEvents(int[][] events) {
​
/* Sort the events in increasing order of their start times */
Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
​
int count = 0;   /* Keeps track of how many events we have attended until today */
int today = 1;   /* Current day of the Event Fest [1 .. 100000] */
​
/* Keeps track of currently live events.
* These contained events may have started earlier, but are still "live" and unattended: all event_end_time >= today */
PriorityQueue<Integer> pq = new PriorityQueue<>();
​
int index = 0;        /* We'd look at the sorted events one by one */
while(!pq.isEmpty() || index < events.length) {
/* If there's no event on the current day, skip to the next event's start day
* Earliest event to start next, is events[index] as array is sorted by start time */
if(pq.isEmpty()) {
today  = events[index][0];//1
}
​
/* The Priority Queue already contains events started before today, and still running
* We pull in more events from the array which are starting today */
while(index < events.length && events[index][0] == today) {
pq.add(events[index][1]);//2
index++;//1
}
​
/* Here we have a simiplied version of the problem as we can assume all events in the PriorityQueue have started today
* If all events started on the same day, we would first attend the event which ends first */
pq.remove();
today++;
count++;
​
/* It was a fun event yesterday, if there were multiple events ending yesterday, we could've attended just one */
while(!pq.isEmpty() && pq.peek() < today) {
pq.remove();
}
}
​
​
return count;
}
}