class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        
        int len = s.length();
        boolean[] seen = new boolean[len + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int start = queue.remove();
            if(start == len) return true;
           
            for(int i = start + 1; i<=len; i++) {
                 if(seen[i]) {
                     continue;
                 }
                if(set.contains(s.substring(start, i))) {
                    queue.add(i);
                    seen[i] = true;
                }
            }
        }
        return false;
    }
}