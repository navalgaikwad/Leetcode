class Solution {

    public int longestSquareStreak(int[] nums) {
        int longestStreak = 0;

        // Create a Set to store all unique numbers from the input array
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        // Iterate through each number in the input array
        for (int startNumber : nums) {
            int currentStreak = 0;
            long current = startNumber;

            // Continue the streak as long as we can find the next square in the set
            while (uniqueNumbers.contains((int) current)) {
                currentStreak++;

                // Break if the next square would be larger than 10^5 (problem constraint)
                if (current * current > 1e5) break;

                current *= current;
            }

            // Update the longest streak if necessary
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        // Return -1 if no valid streak found, otherwise return the longest streak
        return longestStreak < 2 ? -1 : longestStreak;
    }
}