class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null) {
            return result;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            String current = q.remove();
            if(isValid(current)) {
                found = true;
                result.add(current);
            }
            if(found) {
                continue;
            }
            for(int i =0; i<current.length(); i++) {
                if(current.charAt(i)!='(' && current.charAt(i)!=')') continue;
                String value = current.substring(0, i) + current.substring(i + 1);
                if(!visited.contains(value)) {
                    q.add(value);
                    visited.add(value);
                }
            }
        }
        return result;
    }
    
    boolean isValid(String s) {
      int count = 0;
    
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }
    
      return count == 0;
    }
}