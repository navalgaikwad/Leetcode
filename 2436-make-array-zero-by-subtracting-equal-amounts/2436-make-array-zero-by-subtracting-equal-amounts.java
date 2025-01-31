class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new  PriorityQueue<Integer>((a,b)->b-a);
        for(int num : nums) {
            if(num > 0) pq.add(num);
        }
        int count =0;
        int currentMin = 0;
        while(!pq.isEmpty()) {
            int top = pq.peek() - currentMin;
            if(top!=0) {
                currentMin += top;
                count++;
            }
            pq.remove();

        } 
        return count;
    }
}