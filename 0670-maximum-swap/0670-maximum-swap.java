class Solution {
    public int maximumSwap(int num) {
        String value = String.valueOf(num); // Convert the number to a string
        char[] val = value.toCharArray(); // Convert the string to a character array
        int n = val.length;
        
        // Array to store the index of the largest digit to the right of each digit
        int[] maxRight = new int[n];
        int maxIndex = n - 1; // Initialize maxIndex to the last digit
        
        // Traverse the number from right to left to find the largest digits to the right
        for (int i = n - 1; i >= 0; i--) {
            if (val[i] > val[maxIndex]) {
                maxIndex = i;
            }
            maxRight[i] = maxIndex;
        }

        // Traverse the number from left to right to find the first place to swap
        for (int i = 0; i < n; i++) {
            // If there is a larger digit to the right, swap it with the current digit
            if (val[i] != val[maxRight[i]]) {
                char temp = val[i];
                val[i] = val[maxRight[i]];
                val[maxRight[i]] = temp;
                break; // Only one swap is allowed
            }
        }

        // Convert the modified char array back to an integer
        return Integer.parseInt(new String(val));
    }
}
