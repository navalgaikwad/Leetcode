class Solution {
    public int countVowelSubstrings(String word) {
        Set<Character> set;
        int count = 0;
        for (int i = 0; i < word.length() - 4; i++) {
            set = new HashSet<>();
            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                if (isVowel(c)) {
                    set.add(c);
                    if (set.size() == 5) {
                        count++;
                    }
                } else {
                    break;
                }

            }
        }
        return count;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}