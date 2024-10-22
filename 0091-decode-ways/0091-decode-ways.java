class Solution {
    public int numDecodings(String s) {
        return helper(s, 0, new HashMap<>());
    }
    int helper(String s, int start, HashMap<Integer, Integer> memo) {
        if(start == s.length()) {
            return 1;
        }
        if(s.charAt(start) == '0') {
            return 0;
        }
        if(memo.containsKey(start)) {
            return memo.get(start);
        }
        int count = helper(s, start + 1, memo);
        if(start + 2 <= s.length() && Integer.parseInt(s.substring(start, start + 2)) <=26) {
            count+= helper(s, start + 2, memo);
            
        }
        memo.put(start, count);
        return count;
    }
}