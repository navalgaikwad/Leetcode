class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> current = new PriorityQueue<>((a,b)->b-a);
        current.add(0);
        for(int i=0; i<mat.length; i++) {
            PriorityQueue<Integer> next = new PriorityQueue<>((a,b)->b-a);
            for(int j=0; j<mat[0].length; j++) {
                 
                for(Integer sum : current) {
                    next.add(sum + mat[i][j]);
                    if(next.size() > k) {
                        next.remove();
                    }
                }
            }
            current = next;
        }
        return current.remove();
    }
}