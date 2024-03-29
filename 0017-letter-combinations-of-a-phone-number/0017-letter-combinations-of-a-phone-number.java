class Solution {
     List<String> result = new ArrayList<>();
    private Map<Character, String> map = Map.of('2', "abc", '3', "def", 
    '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        helper(digits, new StringBuilder(), 0);
        return result;
    }
    
    void helper(String digits, StringBuilder path, int index) {
        if(path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        String combination = map.get(digits.charAt(index));
        for(char c: combination.toCharArray()) {
            path.append(c);
            helper(digits, path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}