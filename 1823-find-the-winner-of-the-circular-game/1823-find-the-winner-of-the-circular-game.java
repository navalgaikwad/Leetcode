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
        k = k - 1;// reduce it by 1
        while(!q.isEmpty()) {
            i = (i + k) % q.size(); //based on size and find the index
            q.remove(i);
            if(q.size() == 1) {
                break;
            }
        }
        //System.out.print(q);
        return q.get(0);
    }
}
