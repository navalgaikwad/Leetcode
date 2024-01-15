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
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            String word = pair.word;
            int level = pair.level;
            if(word.equals(endWord)) {
                return level;
            }
            
            for(int i=0; i<word.length(); i++) {
                char[] c = word.toCharArray();
                for(char j ='a'; j<='z'; j++) {
                    c[i] = j;
                    if(set.contains(String.valueOf(c))) {
                        q.add(new Pair(String.valueOf(c), level+1));
                        set.remove(String.valueOf(c));
                    }
                }
            }
        }
        return 0;
    }
}