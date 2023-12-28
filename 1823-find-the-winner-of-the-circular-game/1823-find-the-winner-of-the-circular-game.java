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
        // int ans = 0;
        // for(int i = 1; i <= n; i++)
        // {
        //     ans = (ans + k) % i;
        // }
        // return ans + 1;
        
        int i = 1, ans = 0;
 
    // Run a while loop till i <= N
        while (i <= n) {
 
      // Update the Value of ans and Increment i by 1
        ans = (ans + k) % i;
        System.out.println(ans +"-"+ k +"-" + i);
        i++;
       }
 
    // Return required answer
    return ans + 1;
    }
}
//https://www.geeksforgeeks.org/josephus-problem/
//n = 5
// k = 2

// ans = 0  # Initial value before the loop starts

// # Loop starts
// for i in range(1, n + 1):
//     ans = (ans + k) % i

// # Iteration 1:
// #   i = 1, ans = (0 + 2) % 1 = 0

// # Iteration 2:
// #   i = 2, ans = (0 + 2) % 2 = 0

// # Iteration 3:
// #   i = 3, ans = (0 + 2) % 3 = 2

// # Iteration 4:
// #   i = 4, ans = (2 + 2) % 4 = 0

// # Iteration 5:
// #   i = 5, ans = (0 + 2) % 5 = 2

// # Loop ends

// # Final result
// result = ans + 1  # ans = 2, so result = 3

// print(result)