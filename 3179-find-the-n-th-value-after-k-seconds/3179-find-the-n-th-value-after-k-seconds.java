class Solution {
    public int valueAfterKSeconds(int n, int k) {
        // Initialize an array with all 1's
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = 1;
        }
        int sum = 0;
        int c = 0;
        // Simulate the process for k seconds
        while(c < k){
            c++;
            // Update each element of the array based on the sum of its adjacent elements
            for(int i=1; i<n; i++){
                // Calculate the new value of the current element
                sum = (int)((arr[i-1] + arr[i]) % (Math.pow(10,9) + 7));
                arr[i] = sum; // Update the current element with the new value
            }
        }
        // Return the value of the last element after k seconds
        return (arr[n-1]);
    }
}
