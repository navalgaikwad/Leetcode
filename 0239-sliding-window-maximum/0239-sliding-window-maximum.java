class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q =new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index =0;
        for(int i=0; i<n; i++) {
            while(!q.isEmpty() && nums[i] > nums[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(i);
            if(q.getFirst() + k == i) {
                q.removeFirst();
            }

            if( i >= k-1) {
                result[index++] = nums[q.getFirst()];
            }

        }
        return result;
    }
}