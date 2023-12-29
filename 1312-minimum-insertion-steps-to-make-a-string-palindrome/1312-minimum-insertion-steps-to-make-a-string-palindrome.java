class Solution {
    public int minInsertions(String s) {
        String sb = "";
        for(int i=0;i<s.length(); i++) {
            sb =s.charAt(i)+sb+"";
        }
        
        int len = lcs(s, sb, s.length() - 1, s.length()-1, new HashMap<>());
        return s.length() - len;
    }
    
    int lcs(String s, String t, int i, int j, Map<String, Integer> memo) {
        String key = i+"-"+j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if( i< 0 || j < 0) { //if it less than zero, i made == 0
            return 0;
        }
        if(s.charAt(i)==t.charAt(j)) {
            return 1 + lcs(s, t, i - 1, j-1, memo);
        }
        int result = Math.max(lcs(s, t, i - 1, j, memo), lcs(s, t, i, j-1, memo));
        memo.put(key, result);
        return result;
    }
}

//make identify the string is palindrome or not
//make reverse of string
//pass it to the lcs
//when it return value
// minus it from total len and value