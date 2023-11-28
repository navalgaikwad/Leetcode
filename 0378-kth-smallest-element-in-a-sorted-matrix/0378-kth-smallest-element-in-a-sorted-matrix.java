class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b - a));
        for(int[] nums: matrix){
            for(int num: nums){
                pq.add(num);
                while(pq.size() > k){
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }
}