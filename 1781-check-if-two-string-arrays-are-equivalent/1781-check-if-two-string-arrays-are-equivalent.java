class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String left = ""; // Initialize left and right to empty strings
        String right = "";

        // Concatenate strings in word1
        for (int i = 0; i < word1.length; i++) {
            left += word1[i];
        }

        // Concatenate strings in word2
        for (int i = 0; i < word2.length; i++) {
            right += word2[i];
        }

        // Use equals() method to compare strings
        return left.equals(right);
    }
}