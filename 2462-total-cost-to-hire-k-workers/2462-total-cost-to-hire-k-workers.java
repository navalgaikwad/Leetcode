class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> firstPq = new PriorityQueue<>();
        PriorityQueue<Integer> secondPq = new PriorityQueue<>();
        for(int i =0;i<candidates;i++) {
            firstPq.add(costs[i]);
        }
        
         for(int i =Math.max(candidates, costs.length - candidates);i<costs.length;i++) {
            secondPq.add(costs[i]);
        }
        
        long answer =0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;
        
        for(int i =0; i < k; i++) {
            if(secondPq.isEmpty() || !firstPq.isEmpty() && firstPq.peek() <= secondPq.peek()) {
               answer+= firstPq.poll();
                if(nextHead<=nextTail) {
                    firstPq.add(costs[nextHead++]);
                }
            }else {
               answer+= secondPq.poll();
                if(nextHead<=nextTail) {
                    secondPq.add(costs[nextTail--]);
                }
            }
        }
        return answer;
    }
}