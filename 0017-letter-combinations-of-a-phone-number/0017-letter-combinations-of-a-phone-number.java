class Solution {
    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        
         if (digits == null || digits.length() == 0) {
            return result;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(digits, "");
        return result;
        
    }
    
    void dfs(String digits, String ans) {
        if(digits.isEmpty()) {
            result.add(new String(ans));
            return;
        }
        char number = digits.charAt(0);
        String value = map.get(number);
        for(char c: value.toCharArray()) {
            dfs(digits.substring(1), ans+c);
        }
    }
}