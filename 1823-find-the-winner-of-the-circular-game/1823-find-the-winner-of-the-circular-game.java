class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> q = new LinkedList<>();
        for(int i = 1; i<= n; i++) {
            q.add(i);
        }
        int i = 0; //make it global 
        while(q.size() > 1) {
            i = (i+ k - 1)% q.size(); //based on size it should reduce and find the index
            q.remove(i);
        }
        return q.get(0);
    }
}
