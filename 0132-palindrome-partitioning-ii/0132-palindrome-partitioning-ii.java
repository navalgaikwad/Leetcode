class Solution {
    public int minCut(String s) {
        Integer[] memo = new Integer[s.length()];
        return helper(s, 0, memo);
    }
    
    static boolean palindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    int helper(String s, int start, Integer[] memo) {
        if(start == s.length()) {
            return -1;
        }
        if(memo[start] != null) {
            return memo[start];
        }
        int minCut = Integer.MAX_VALUE;
        //duplicate allowed ahe mhnun i =index and recursion madhye i  +1
        for(int i = start; i<s.length(); i++) {
            if(palindrome(s, start, i)) {
                int count = helper(s, i + 1, memo);
                int sum = 1 + count;
                if(minCut == Integer.MAX_VALUE  || sum < minCut) {
                    minCut = Math.min(minCut, sum);
                }
            }
        }
        memo[start] = minCut;
        return minCut;
    }
}