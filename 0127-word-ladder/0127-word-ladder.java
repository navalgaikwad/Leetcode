class Solution {
    class Pair {
        String wrd;
        int level;

        Pair(String wrd, int level) {
            this.wrd = wrd;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            String word = p.wrd;
            int level = p.level;
            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] array = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    array[i] = c;
                    if (set.contains(String.valueOf(array))) {
                        set.remove(String.valueOf(array));
                        q.add(new Pair(String.valueOf(array), level + 1));
                    }
                }
            }
        }
        return 0;
    }
}