class Solution {
    public int maximumSwap(int num) {
        // Convert the number to a string
        String s = Integer.toString(num);
        char[] chars = s.toCharArray(); // Convert the string to a char array

        int maxPos = chars.length - 1;
        int bestSrc = -1, bestDest = -1;

        // Traverse the number from right to left
        for (int i = chars.length - 1; i >= 0; --i) {
            if (chars[i] > chars[maxPos]) {//find max
                maxPos = i; // Update the position of the maximum digit
            } else if (chars[i] < chars[maxPos]) {//find min
                bestSrc = maxPos;  // Store the position of the larger digit
                bestDest = i;      // Store the position of the smaller digit
            }
        }
        if(bestDest == -1)  return Integer.parseInt(new String(chars));
        // If there's a beneficial swap, perform it
        if (maxPos != -1) {
            char temp = chars[bestSrc];
            chars[bestSrc] = chars[bestDest];
            chars[bestDest] = temp;
        }

        // Convert the modified char array back to an integer
        return Integer.parseInt(new String(chars));
    }
}
