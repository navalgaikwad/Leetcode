class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> word = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);//add 0 index
        int len = s.length();
        while(!queue.isEmpty()){
            int start = queue.remove();
            if(start == len){
                return true;
            }
            for(int end = start + 1; end <= len; end++){
                if(seen[end]){
                    continue;
                }
                if(word.contains(s.substring(start, end))){
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }
        return false;
    }
}