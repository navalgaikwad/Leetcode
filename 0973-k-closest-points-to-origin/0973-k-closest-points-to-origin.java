import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Initialize a priority queue with a custom comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        // Add points to the priority queue
        for (int[] point : points) {
            pq.offer(point);
            // Remove the farthest point if the size of the priority queue exceeds k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Create an array to store the k closest points
        int[][] result = new int[k][2];
        int i = 0;
        // Extract points from the priority queue
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }
}
