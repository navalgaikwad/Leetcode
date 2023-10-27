class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        Boolean[][] palindromeMemo = new Boolean[s.length()][s.length()];
        helper(0, new ArrayList<String>(), result, s, palindromeMemo);
        return result;
    }
    
    void helper(int start, List<String> runningList, List<List<String>> result, String s, Boolean[][] palindromeMemo){
        if(start >= s.length()){
            result.add(new ArrayList<>(runningList));
            return;
        }
        
        for(int i = start; i < s.length(); i++){
            if(palindrome(start, i, s, palindromeMemo)){
                runningList.add(s.substring(start, i + 1));
                helper(i + 1, runningList, result, s, palindromeMemo);
                runningList.remove(runningList.size() - 1);
            }
        }
    }
    
    boolean palindrome(int start, int end, String s, Boolean[][] palindromeMemo){
        if(start >= end) return true;
        if(palindromeMemo[start][end] != null){
            return palindromeMemo[start][end];
        }
        
        if(s.charAt(start) == s.charAt(end)){
            palindromeMemo[start][end] = palindrome(start + 1, end - 1, s, palindromeMemo);
            return palindromeMemo[start][end];
        }
        
        palindromeMemo[start][end] = false;
        return false;
    }
}
