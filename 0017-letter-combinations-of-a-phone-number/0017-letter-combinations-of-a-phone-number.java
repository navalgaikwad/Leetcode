class Solution {
    List<String> result = new ArrayList<>();
    Map<Character, String> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return result;
        
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        helper(digits, "", 0);
        
        return result;
    }
    
    void helper(String digits, String ans, int index) {
        if(index == digits.length()) {
            result.add(new String(ans));//ad
            return;
        }
        String value = map.get(digits.charAt(index));//abc // def
        
        for(char c: value.toCharArray()) {//def
           helper(digits, ans+c, index + 1); //ab
        }
    }   
}

/*
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

2 :abc
3: def

2
ad

2: abc
3: def
ad, ae, af, b



*/