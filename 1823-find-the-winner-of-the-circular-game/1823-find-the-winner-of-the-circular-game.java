class Solution {
    public int findTheWinner(int n, int k) {
        // if(n == 1 && k == 1) { //handling the edge condition
        //     return 1;
        // }
        // List<Integer> q = new LinkedList<>();
        // for(int i = 1; i<= n; i++) {
        //     q.add(i);
        // }// added all the numbers
        // int i = 0; //make it global so we play with i to find next index
        // k = k - 1;// reduce it by 1
        // while(!q.isEmpty()) {
        //     i = (i + k) % q.size(); //based on size and find the index
        //     q.remove(i);
        //     if(q.size() == 1) { // we need size is equal to one than break it
        //         break;
        //     }
        // }
        // //System.out.print(q);
        // return q.get(0);
        int ans = 0;
        for(int i = 1; i <= n; i++)
        {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }
}