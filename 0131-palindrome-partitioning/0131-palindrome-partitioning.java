class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        Boolean[][] memo = new Boolean[s.length()][s.length()];
        helper(s, 0, memo, result, new ArrayList<>());
        return result;
    }
    
    void helper(String a, int j, Boolean[][] memo, List<List<String>> result, List<String> runningList) {
        if(j >= a.length()) {
            result.add(new ArrayList<>(runningList));
            return;
        }
        for(int i = j; i<a.length(); i++) {
            if(palindrome(a, j, i, memo)) {
                runningList.add(a.substring(j, i+1));
                helper(a, i+1, memo, result, runningList);
                runningList.remove(runningList.size() - 1);
            }
        }
    }
    
    boolean palindrome(String s, int i, int j, Boolean[][] memo) {
        if(i >= j) {
            return true;
        }
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        if(s.charAt(i) == s.charAt(j)) {
            memo[i][j] = palindrome(s, i+1, j-1, memo);
            return memo[i][j];
        }
        memo[i][j] = false;
        return false;
    }
}