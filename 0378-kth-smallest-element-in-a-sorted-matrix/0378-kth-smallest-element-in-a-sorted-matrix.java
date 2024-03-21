class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                pq.add(matrix[i][j]);
            }
        }
       // System.out.print(pq);
        k = k -1;
        while( k > 0) {
            pq.remove();
            k--;
        }
        return pq.peek();
    }
}

/*
[1,5,9],
[10,11,13],
[12,13,15]

*/