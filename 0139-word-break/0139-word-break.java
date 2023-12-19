class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int len = s.length();
        boolean[] seen = new boolean[len + 1];
        
        while(!q.isEmpty()) {
            int start = q.remove();
            if(start == len){return true;}
          
            for(int end = start + 1; end<=len; end++) {
                
                if(seen[end]) {continue;}
                if(set.contains(s.substring(start, end))) {
                   seen[end] = true;
                   q.add(end);
               } 
            } 
        }
        return false;
    }
}