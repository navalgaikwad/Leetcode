class Solution {
    List<String> result = new ArrayList<>();
    private Map<Character, String> map = Map.of('2', "abc", '3', "def", 
    '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
       if (digits.length() == 0) return result;
       backTracking(0, new StringBuilder(), digits);
       return result;
    }
    
    void backTracking(int index, StringBuilder path, String digit) {
        if(path.length() == digit.length()) {
            result.add(path.toString());
            return;
        }
        String combination = map.get(digit.charAt(index));
        for(char c: combination.toCharArray()) {
            path.append(c);
            backTracking(index + 1, path, digit);
            path.deleteCharAt(path.length() - 1);
        }
    }
}