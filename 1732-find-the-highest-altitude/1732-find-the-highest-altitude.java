class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n+1];
        int max = 0;
       // prefix[0] = 0;
        for(int i= 0; i < n; i++) {
            prefix[i+1] = prefix[i] + gain[i];
            max = Math.max(max, prefix[i+1]);
        }
       return max; 
    }
}

// //-5,1,5,0,-7
// //0,-5, -4,1,1,-6
// class Solution {
//     public int largestAltitude(int[] gain) {
//         int n = gain.length;
//         int[] prefix = new int[n + 1]; // Increase the size of prefix array to include the initial altitude
//         int max = 0;
//         prefix[0] = 0; // Initial altitude is 0

//         for(int i = 0; i < n; i++) {
//             prefix[i + 1] = prefix[i] + gain[i]; // Calculate the new altitude
//             max = Math.max(max, prefix[i + 1]); // Update the maximum altitude
//         }

//         return max; 
//     }
// }
