class Solution {
    class Pair {
        String word;
        int level;
        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()) {
            Pair current = q.remove();
            String word = current.word;
            int level = current.level;
            if(word.equals(endWord)) {
                return level;
            }
            for(int i=0; i<word.length(); i++) {
                char[] wrd = word.toCharArray();
                for(char c = 'a'; c<='z'; c++) {
                    wrd[i] = c;
                    if(set.contains(String.valueOf(wrd))) {
                        q.add(new Pair(String.valueOf(wrd), level  + 1));
                        set.remove(String.valueOf(wrd));
                    }
                }
            }
            
        }
        return 0;
    }
}