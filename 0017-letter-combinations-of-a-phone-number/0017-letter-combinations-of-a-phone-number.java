class Solution {
    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
         if (digits.length() == 0) return result;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backTracking(digits, "", 0);
        return result;
    }
    
    void backTracking(String digits, String ans, int index) {
        if(index == digits.length()) {
            result.add(new String(ans));
            return;
        }
        String value = map.get(digits.charAt(index));
        for(char c : value.toCharArray()) {
            backTracking(digits, ans+c, index+1);
        }
    }
   
}