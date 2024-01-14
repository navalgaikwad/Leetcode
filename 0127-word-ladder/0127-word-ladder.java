class Solution {
    class Pair {
        int level;
        String word;
        Pair(int level, String word) {
            this.level = level;
            this.word = word;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, beginWord));
       
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int level = p.level;
            String word = p.word;
            if(word.equals(endWord)) {
                return level;
            }
            
        for(int i=0; i<word.length(); i++) {
            char[] c = word.toCharArray();
             for(char j = 'a'; j<='z';j++) {
                 c[i] = j;
                 String replc = String.valueOf(c);
                 if(set.contains(replc)) {
                    q.add(new Pair(level+1, replc));
                    set.remove(replc);
                 }
             }
        }
    }
        return 0;
    } 
}