class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        Boolean[][] memo = new Boolean[s.length()][s.length()];
        
        helper(0, s, result, new ArrayList<>(), memo);
        return result;
    }
    
    void helper(int start, String s, List<List<String>> result, List<String> runningList, Boolean[][] memo) {
        if(start >= s.length()) {
            result.add(new ArrayList<>(runningList));
            return;
        }
        for(int i = start; i<s.length(); i++) {
            if(palindrome(start, i, s, memo)) {
                runningList.add(s.substring(start, i + 1));
                helper(i + 1, s, result, runningList, memo);
                runningList.remove(runningList.size() - 1);
            }
        }
    }
    
    boolean palindrome(int start, int end, String s, Boolean[][] memo) {
        if(start >= end) {
            return true;
        }
        if(memo[start][end]!=null) {
            return memo[start][end];
        }
        if(s.charAt(start)==s.charAt(end)) {
            memo[start][end] = palindrome(start + 1, end - 1, s, memo);
            return memo[start][end];
        }
        memo[start][end] = false;
        return false;
    }
}