class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq = new  PriorityQueue<>((a, b)-> b - a);
        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size() > 1) {
            int x = pq.remove();
            int y = pq.remove();
            if(x != y){
                int val = Math.abs( x - y);
                pq.add(val);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}