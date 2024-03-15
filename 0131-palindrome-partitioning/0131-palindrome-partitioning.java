class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<>(), 0);
        return result;
    }
    
    void helper(String s, List<String> ans, int index) {
        if(s.length() == index) {
            result.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i = index; i <s.length(); i++) {
            if(isValid(s, index, i)) {
                ans.add(s.substring(index, i+1));
                helper(s, ans, i + 1);
                ans.remove(ans.size()-1);
            }
        }
    }
    
    
    
    boolean isValid(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}