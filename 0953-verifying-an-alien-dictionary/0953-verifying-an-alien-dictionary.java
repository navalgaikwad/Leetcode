class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        // Create a map for the order of each character
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        // Compare each word with the next word
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int size = Math.min(w1.length(), w2.length());

            // Compare characters one by one
            for (int j = 0; j < size; j++) {
                if (map[w1.charAt(j) - 'a'] < map[w2.charAt(j) - 'a']) {//sequentail
                    break;
                } else if (map[w1.charAt(j) - 'a'] > map[w2.charAt(j) - 'a']) {//
                    return false;
                } else if (j == size - 1 && w1.length() > w2.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
