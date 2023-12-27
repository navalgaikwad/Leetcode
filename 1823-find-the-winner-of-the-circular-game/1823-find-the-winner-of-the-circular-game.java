class Solution {
    public int findTheWinner(int n, int k) {
        if(n == 1 && k == 1) {
            return 1;
        }
        List<Integer> q = new LinkedList<>();
        for(int i = 1; i<= n; i++) {
            q.add(i);
        }
        int i = 0; //make it global 
        while(!q.isEmpty()) {
            i = (i + k - 1) % q.size(); //based on size it should reduce and find the index
            q.remove(i);
            if(q.size()== 1) {
                break;
            }
        }
        System.out.print(q);
        return q.get(0);
    }
}
