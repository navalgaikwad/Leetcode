class Solution {
    class Pair{
        String first;
        int level;
        Pair(String first, int level){
           this.first = first;
           this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set  = new HashSet<>();
        for(String word: wordList){ //O(n)
            set.add(word);
        }
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){ 
            Pair current = q.remove();
           String first = current.first;
            int level = current.level;
            if(endWord.equals(first)){
                return level;
            }
            for(int i=0; i<first.length(); i++){
                char[] replacement = first.toCharArray();
                for(char j ='a'; j<='z'; j++){
                    replacement[i] = j;
                    String replc = String.valueOf(replacement);
                    if(set.contains(replc)){
                        set.remove(replc);
                        q.add(new Pair(replc, level+1));
                    }
                }
            }
        }
        return 0;
    }
}